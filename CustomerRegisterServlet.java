package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class CustomerRegisterServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
	CustomerBean cb=new CustomerBean();

	HttpSession hs=req.getSession(false);
	hs.setAttribute("msg","Customer Register Successfully..!!!");
	req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
}
}
