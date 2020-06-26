package controller.product;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrdersDAO;
import model.Orders;

@WebServlet(urlPatterns = {"/listorder"})

public class ListOrders extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		try {
			List<Orders> ls = new OrdersDAO().listOrders();
			req.setAttribute("listOrders", ls);
			req.getRequestDispatcher("/WEB-VIEW/listOrder.jsp").forward(req, resp);
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
