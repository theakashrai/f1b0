import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class Edit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 542185777570081290L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String idx = (String) session.getAttribute("id");
		if (idx == null) {
			req.setAttribute("errorMsg", "You must login first!!");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
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
			Patient patient = new Patient();
			while (rs.next()) {
				patient.setId(rs.getInt(1));
				patient.setName(rs.getString(2));
				patient.setMobileNumber(rs.getLong(3));
				patient.setRoomNo(rs.getInt(4));
				patient.setDisease(rs.getString(5));
				patient.setDateOfAdmission(rs.getString(6));
				patient.setDateOfDischarge(rs.getString(7));
			}
			req.setAttribute("patient", patient);
			req.getRequestDispatcher("edit.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}