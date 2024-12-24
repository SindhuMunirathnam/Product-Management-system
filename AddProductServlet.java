package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	HttpSession hs=req.getSession(false);//Accessing existing session
	if(hs==null)
	{
		req.setAttribute("msg","session expired..<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);	
	}
	else
	{
		ProductBean pb=new ProductBean();//Bean object
		pb.setpCode(req.getParameter("pcode"));
		pb.setpName(req.getParameter("pname"));
		pb.setPrice(Float.parseFloat(req.getParameter("price")));
		pb.setQty(Integer.parseInt(req.getParameter("qty")));
		int k=new AddProductDAO().insert(pb);
		if(k>0)
		{
			req.setAttribute("msg","Product Added Successfully..<br>");
			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
		}
	}
}
}
