import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/delete")
public class Delete extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String id=req.getParameter("PatientID");
		
		try {
			//load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			           //create connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
			               //create statement
		Statement stmt=con.createStatement();
		String sql="delete from patients where PatientID="+id;
		int i=stmt.executeUpdate(sql);
		if(i>0) {
			res.sendRedirect("admin");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
