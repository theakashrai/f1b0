import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/add")
public class Add extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			// create statement

			String pn = req.getParameter("name");
			String m = req.getParameter("mob");
			String r = req.getParameter("rom");
			String d = req.getParameter("dis");
			String doa = req.getParameter("doa");
			String dod = req.getParameter("dod");
			Statement stmt = con.createStatement();
			String sql = "insert into patients(Name,Mobile,RoomNo,Disease,Date_of_admit,Date_of_discharge) values('"
					+ pn + "'," + m + "," + r + ",'" + d + "','" + doa + "','" + dod + "')";
			int i = stmt.executeUpdate(sql);
			if (i > 0) {
				out.println("Your data is inserted");
				res.sendRedirect("admin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
