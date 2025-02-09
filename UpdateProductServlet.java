package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet
{
	@Override
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
 {
	 HttpSession hs=req.getSession(false);
	 if(hs==null)
	 {
		 req.setAttribute("msg","Session Expired...<br>");
		 req.getRequestDispatcher("Msg.jsp").forward(req, res);
	 }
	 else
	 {
		 ArrayList<ProductBean>al=(ArrayList<ProductBean>)hs.getAttribute("alist");
		 String pCode=req.getParameter("pcode");
		 float pPrice=Float.parseFloat(req.getParameter("price"));
		 int pQty=Integer.parseInt(req.getParameter("qty"));
		 Iterator<ProductBean>it=al.iterator();
		 while(it.hasNext())
		 {
			 ProductBean pb=(ProductBean)it.next();
			 if(pCode.equals(pb.getpCode()))
			 {
				 pb.setPrice(pPrice);//updating productBran
				 pb.setQty(pQty);
				 int k=new UpdateProductDAO().update(pb);
				 if(k>0)
				 {
					 req.setAttribute("msg","Product updated Successfully..<br>");
					 req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
				 }
				 break;
			 }
		 }
	 }
 }
}
