package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.OrdersDAO;
import model.Cart;
import model.Orders;

@WebServlet(urlPatterns = {"/payment"}) 

public class PayController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("cart") == null) {
			req.setAttribute("msg", "There is no Products in Cart!");
			req.getRequestDispatcher("/WEB-VIEW/cart.jsp").forward(req, resp);
		}
		
		try {
			
			OrdersDAO dao = new OrdersDAO();
			Cart c = (Cart) session.getAttribute("cart");
			String customername = req.getParameter("customername");
			String discount = req.getParameter("discount");
			String address = req.getParameter("address");
			
			if(c.getItems().size() > 0) {		
				Date date = new Date();
				Orders d = new Orders(customername, 0, discount, address, "", date);
				dao.insertOrder(d, c);
				
				req.setAttribute("msg", "ORDER SUCCESSFULLY!!! ");
				session.invalidate();
				req.getRequestDispatcher("/WEB-VIEW/cart.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "There are no products on Cart! Go get some.");
				req.getRequestDispatcher("/WEB-VIEW/cart.jsp").forward(req, resp);
			}
			
		} catch(Exception ex) {
			resp.getWriter().println(ex);
		}
	}
	
}
