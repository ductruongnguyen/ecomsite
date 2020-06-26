package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;


public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		if(action == null) {
			req.getRequestDispatcher("/WEB-VIEW/home.jsp").forward(req, resp);
		} else if(action.equals("logout")) {
			
			  Cookie userCookie = new Cookie("email", null);
			  Cookie pwdCookie = new Cookie("password", null);
			  
			  userCookie.setMaxAge(0);
			  pwdCookie.setMaxAge(0);
			  
			  resp.addCookie(userCookie);
			  resp.addCookie(pwdCookie);
			  
			  HttpSession httpSession = req.getSession();
			  httpSession.invalidate();
			  
			  //Set null values for input and error message
			  HttpSession session = req.getSession();
			
			  Account account = new Account("", "");
			  session.setAttribute("account", account);
			  
			  req.setAttribute("message", "");
			  req.setAttribute("msg", "You have successfully logged out.");
			  
			  req.getRequestDispatcher("/WEB-VIEW/login.jsp").forward(req, resp);
			  
		}
		
	}
	
}
