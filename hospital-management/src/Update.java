import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4709252279621713813L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		HttpSession session = req.getSession();
		String idx = (String) session.getAttribute("id");
		if (idx == null) {
			req.setAttribute("errorMsg", "You must login first!!");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}

		String id = req.getParameter("id");
		String n = req.getParameter("name");
		String m = req.getParameter("mob");
		String r = req.getParameter("rom");
		String d = req.getParameter("dis");
		String doa = req.getParameter("doa");
		String dod = req.getParameter("dod");
		try {
			// load Driver class
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			// create statement
			Statement stmt = con.createStatement();
			String sql = "update patients set Name='" + n + "', Mobile=" + m + ", RoomNo=" + r + ", Disease='" + d
					+ "', Date_of_admit='" + doa + "', Date_of_discharge='" + dod + "' where PatientID=" + id;

			stmt.executeUpdate(sql);

			res.sendRedirect("admin");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
