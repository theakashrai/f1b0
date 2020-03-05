import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7190956441666237829L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);

	}
}