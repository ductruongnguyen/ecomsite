package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/search"})

public class SearchController2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		try {
			String text = req.getParameter("keyword");
			List<Product> list = new ListProductDAO().search(text);
			
			if(text == "" || list.isEmpty()) {
				req.setAttribute("message", "There is no matching products.Try again!");
				req.getRequestDispatcher("/WEB-VIEW/search.jsp").forward(req, resp);
			} else {
				req.setAttribute("results", list);
				req.getRequestDispatcher("/WEB-VIEW/search.jsp").forward(req, resp);
			}
		} catch(Exception ex) {
			resp.getWriter().println(ex);
		}
		
	}
	
}
