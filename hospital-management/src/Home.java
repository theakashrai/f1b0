import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

@WebServlet("/home")
public class Home extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7965217652883616052L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String p = req.getParameter("pid");
		String n = req.getParameter("name");

		if (validate(p, n)) {
			try {
				// load Driver class
				Class.forName("com.mysql.jdbc.Driver");
				// create connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
				// create statement
				Statement stmt = con.createStatement();
				String sql = "select * from patients where PatientID=" + p + " And Name='" + n + "'";
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
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("errorMsg","Sorry! You have entered wrong name or patientID");
		}
		req.getRequestDispatcher("patient_info.jsp").forward(req, res);

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
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;

	}
}
