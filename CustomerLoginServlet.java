package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/customer")
public class CustomerLoginServlet  extends HttpServlet{
	@Override
	 protected  void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	 {
		String uNmae=req.getParameter("uname");
		String pWord=req.getParameter("pword");
		CustomerBean cb=new CustomerLoginDAO().login(uNmae, pWord);
		if(cb==null)
		{
			req.setAttribute("msg", "Invalid Login Process...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();//creating new session
			hs.setAttribute("cbean",cb);
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	 }
	}

