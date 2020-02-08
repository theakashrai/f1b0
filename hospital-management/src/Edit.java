import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String id = req.getParameter("PatientID");
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "select * from patients where PatientID=" + id;
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<body style='background-image: url(header-banner.jpg); height:700px ;width:700px;'>");
			out.println("<form action='update' method='post'>");
			out.println("<table border='1'>");
			out.println(
					"<tr><th>PatientID</th><th>Name</th><th>Mobile</th><th>RoomNo</th><th>Disease</th><th>Date_of_admit</th><th>Date_of_discharge</th><th colsapn='2'>ACTION</th></tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td><input type='number' name='id' value='" + rs.getInt(1) + "'></td>");
				out.println("<td><input type='text' name='name' value='" + rs.getString(2) + "'></td>");
				out.println("<td><input type='number' name='mob' value='" + rs.getLong(3) + "'></td>");
				out.println("<td><input type='number' name='rom' value='" + rs.getInt(4) + "'></td>");
				out.println("<td><input type='text' name='dis' value='" + rs.getString(5) + "'></td>");
				out.println("<td><input type='date' name='doa' value='" + rs.getDate(6) + "'></td>");
				out.println("<td><input type='date' name='dod' value='" + rs.getDate(7) + "'></td>");
				out.println("<td><input type='submit'value='update'></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</body>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}