package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ListProductDAO;

@WebServlet(urlPatterns = {"/informationProduct"})

public class InformationProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("product", new ListProductDAO().getProduct("" + id));
			req.getRequestDispatcher("/WEB-VIEW/infoProduct.jsp").forward(req, resp);
		} catch(Exception ex) {
			resp.getWriter().println(ex);
		}
	}
	

}
