import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admin")
public class Adminstrator extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1966276265001457295L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		if (id == null) {
			req.setAttribute("errorMsg", "You must login first!!");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			Statement stmt = con.createStatement();
			String sql = "select * from patients";
			ResultSet rs = stmt.executeQuery(sql);
			List<Patient> patientList = new ArrayList<>();
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt(1));
				patient.setName(rs.getString(2));
				patient.setMobileNumber(rs.getLong(3));
				patient.setRoomNo(rs.getInt(4));
				patient.setDisease(rs.getString(5));
				patient.setDateOfAdmission(rs.getString(6));
				patient.setDateOfDischarge(rs.getString(7));
				patientList.add(patient);
			}
			req.setAttribute("patientList", patientList);
			req.getRequestDispatcher("management.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
