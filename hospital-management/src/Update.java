import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/update")
public class Update extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException
    {
    	
    	res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String id=req.getParameter("id");
        String n=req.getParameter("name");
        String m=req.getParameter("mob");
        String r=req.getParameter("rom");
        String d=req.getParameter("dis");
        String doa=req.getParameter("doa");
        String dod=req.getParameter("dod");
        try {
                //load Driver class
    Class.forName("com.mysql.jdbc.Driver");
               //create connection
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
                   //create statement
    Statement stmt=con.createStatement();
    String sql="update patients set Name='"+n+"', Mobile="+m+", RoomNo="+r+", Disease='"+d+"', Date_of_admit='"+doa+"', Date_of_discharge='"+dod+"' where PatientID="+id;
    int i=stmt.executeUpdate(sql);
   if(i>0) {
	   res.sendRedirect("admin");
   }
        }
   catch(Exception e) {
	   e.printStackTrace();
   }
        }
}
