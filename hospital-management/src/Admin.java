import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/adminx")
public class Admin extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try {
			//load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			           //create connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			               //create statement
			Statement stmt=con.createStatement();
			String sql="select * from patients";
	ResultSet rs=stmt.executeQuery(sql);
	out.println("<body style='background-image: url(cartoon-male-doctor-a8Je0VC-600.jpg); height:700px ;width:700px;'>");
	out.println("<table border='1'>");
	out.println("<tr><th>PatientID</th><th>Name</th><th>Mobile</th><th>RoomNo</th><th>Disease</th><th>Date_of_admit</th><th>Date_of_discharge</th><th colspan='2'>ACTION</th></tr>");
	while(rs.next()) {
		out.println("<tr>");
		out.println("<td>"+rs.getInt(1)+"</td>");
		out.println("<td>"+rs.getString(2)+"</td>");
		out.println("<td>"+rs.getLong(3)+"</td>");
		out.println("<td>"+rs.getInt(4)+"</td>");
		out.println("<td>"+rs.getString(5)+"</td>");
		out.println("<td>"+rs.getString(6)+"</td>");
		out.println("<td>"+rs.getString(7)+"</td>");
		out.println("<td><a href='delete?PatientID="+rs.getInt(1)+"'>DELETE</a></td>'");
		out.println("<td><a href='edit?PatientID="+rs.getInt(1)+"'>EDIT</a></td>'");
		out.println("</tr>");
	} 
	out.println("<tr><td colspan='9'><a href='index2.html'>Add</a></td></tr>");
	out.println("</table>");
	out.println("<a href='logout'>Logout</a>");
	out.println("</body>");
		}
	catch(Exception e) {
		e.printStackTrace();
	}
		}
	}
