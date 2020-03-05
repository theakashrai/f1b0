import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2883680972397269480L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String id = req.getParameter("id");
		String p = req.getParameter("pass");
		if (id.equals("admin123@gmail.com") && p.equals("admin123")) {
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(20);
			session.setAttribute("id", id);
			res.sendRedirect("admin");
		} else {

			req.setAttribute("errorMsg", "Wrong username and password");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}
