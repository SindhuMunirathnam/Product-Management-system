package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
		}
		else
		{
			hs.removeAttribute("abean");
			hs.invalidate();//Destroying session
			req.setAttribute("msg","LoggedOut Successfully..<br>");
		}
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}

}
