import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<form action='login' method='post'>");
		out.println("<label> ID </label>");
		out.println("<input type='text' name='id'>");
		out.println("<label> Password </label>");
		out.println("<input type='password' name='pass'>");
		out.println("<input type='submit' name='Submit'>");
		out.println("</form>");
		String id=req.getParameter("id");
		String p=req.getParameter("pass");
		if(id.equals("admin123@gmail.com")&&p.equals("admin123")) {
			HttpSession session=req.getSession();
			session.setMaxInactiveInterval(20);
			session.setAttribute("id", id);
			res.sendRedirect("admin");
		}
			else {
				out.println("you have entered wrong id or password");
			}
		}
	}
	