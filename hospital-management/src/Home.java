import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

@WebServlet("/home")
public class Home extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String p = req.getParameter("pid");
			String n = req.getParameter("name");

			if (validate(p,n)) {
				try {
		             //load Driver class
		 Class.forName("com.mysql.jdbc.Driver");
		            //create connection
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
		                //create statement
		 Statement stmt=con.createStatement();
		 String sql="select * from patients where PatientID="+p+" And Name='"+n+"'";
		 ResultSet rs=stmt.executeQuery(sql);
		 out.println("<form action='home' method='post'>");
		 out.println("<div>");
		 out.println("<table border='1'>");
		 while(rs.next()) {
			 out.println("<tr>");
			 out.println("<th>PatientID</th>");
			 out.println("<td>"+rs.getInt(1)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>Name</th>");
			 out.println("<td>"+rs.getString(2)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>Mobile</th>");
			 out.println("<td>"+rs.getLong(3)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>RoomNo</th>");
			 out.println("<td>"+rs.getInt(4)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>Disease</th>");
			 out.println("<td>"+rs.getString(5)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>Date_of_admit</th>");
			 out.println("<td>"+rs.getString(6)+"</td>");
			 out.println("</tr>");
			 out.println("<tr>");
			 out.println("<th>Date_of_discharge</th>");
			 out.println("<td>"+rs.getString(7)+"</td>");
			 out.println("</tr>");
			 out.println("</table>");
			 out.println("</div>");
			 out.println("</form>");
		 }
		 
				 }
				 catch(Exception e) {
					 e.printStackTrace();
				 }
			} else {
				out.println("Sorry! You have entered wrong name or patientID");
				RequestDispatcher rd=req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
			out.close();

	}

	public static boolean validate(String pid, String name) {
		boolean status = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			PreparedStatement ps = con.prepareStatement("Select * from patients where PatientID = ? And Name= ?");
			ps.setString(1, pid);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			status=rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}
}
