import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

@WebServlet("/display")
public class Display extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		String id=req.getParameter("pid");
		String n=req.getParameter("name");
		 try {
             //load Driver class
 Class.forName("com.mysql.jdbc.Driver");
            //create connection
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
                //create statement
 Statement stmt=con.createStatement();
 String sql="select * from patients where PatientID='"+id+"',Name='"+n+"'";
 ResultSet rs=stmt.executeQuery(sql);
 out.println("<form action='dispaly' method='post'>");
 out.println("<div style='height:700px; width:700px; float:left; margin-top:20px;'>");
 out.println("<table border='1' style='height:500px; width:500px; float:left;'>");
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
	}
}