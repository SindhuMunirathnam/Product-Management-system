package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
 @Override
 protected  void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	String uNmae=req.getParameter("uname");
	String pWord=req.getParameter("pword");
	AdminBean ab=new AdminLoginDAO().login(uNmae, pWord);
	if(ab==null)
	{
		req.setAttribute("msg", "Invalid Login Process...<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}
	else
	{
		HttpSession hs=req.getSession();//creating new session
		hs.setAttribute("abean",ab);
		req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
	}
 }
}
