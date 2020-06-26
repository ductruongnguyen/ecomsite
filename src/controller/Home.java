package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.DBContext;
import dao.ListProductDAO;
import model.Product;

@WebServlet(urlPatterns = {"/home"})

public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//count number of products in DB
			Connection conn = new DBContext().getConnection();
			Statement stmt = conn.createStatement();
			
			String sql = "select count(product_id) as count from products";
			ResultSet rs = stmt.executeQuery(sql);
			
			int count = 0;
			
			if(rs.next()) { 
				 count = Integer.parseInt(rs.getString("count"));
			}
			
			//set the page number
			if(count%8 == 0) {
				int page = count/8;
				req.setAttribute("page", page);
			} else {
				int page = count/8 + 1;
				req.setAttribute("page", page);
				req.setAttribute("max", page);
			}
			
			conn.close();
			
			//get page number
			int pageNum = 0;
			
			if(req.getParameter("page") != null) {
				pageNum = Integer.parseInt(req.getParameter("page"));
				req.setAttribute("currentPage", pageNum);
			}
			
			List<Product> listProduct;
			
			//list products on the home page
			if(pageNum == 0) {
				
				listProduct = new ArrayList<Product>();
				for (int i = 1; i <= 8; i++) {
					Product product = new ListProductDAO().getProduct(String.valueOf(i));
					listProduct.add(product);
				}
				
				req.setAttribute("listProduct", listProduct);
			
			//list products on sub-pages if they're full of 8 products
			} else if((count - (pageNum*8)) > 0) {
				
				listProduct = new ArrayList<Product>();
				for (int i = (pageNum*8 -7); i <= (pageNum*8); i++) {
					Product product = new ListProductDAO().getProduct(String.valueOf(i));
					listProduct.add(product);
				}
				
				req.setAttribute("listProduct", listProduct);
			
			//list products on the last page if it's not full of 8 products
			} else if((count - (pageNum*8)) < 0) {
				
				listProduct = new ArrayList<Product>();
				for (int i = (pageNum*8 -7); i <= count; i++) {
					Product product = new ListProductDAO().getProduct(String.valueOf(i));
					listProduct.add(product);
				}
				
				req.setAttribute("listProduct", listProduct);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-VIEW/home.jsp").forward(req, resp);
	}
	
}
