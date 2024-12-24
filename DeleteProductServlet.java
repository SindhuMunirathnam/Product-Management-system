package test;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
  {
	 HttpSession hs=req.getSession(false);
	 if(hs==null)
	 {
		 req.setAttribute("msg","Session Expired...<br>");
		 req.getRequestDispatcher("Msg.jsp").forward(req, res);
	 }
	 else
	 {
		 String pName=req.getParameter("pname");
		ArrayList<ProductBean>al=( ArrayList<ProductBean>)hs.getAttribute("alist");
		
		for(ProductBean pb:al)
		{
			if(pName.equals(pb.getpName()))
			{
				int k=new DeleteProductDAO().delete(pb);
				if(k>0)
				{
					req.setAttribute("msg","Product Deleted Successfully...<br>");
					req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
					//break;
				}
                return;
				
			}
			else
			{
			  req.setAttribute("msg", "Product is not availabe...<br>");
			  req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
		}
		
	 }
  }
}