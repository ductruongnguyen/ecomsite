package controller.product;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/listproduct"})

public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		try {
			List<Product> ls = new ListProductDAO().search();
			req.setAttribute("products", ls);
			req.getRequestDispatcher("/WEB-VIEW/list.jsp").forward(req, resp);
		} catch(Exception ex) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
}
