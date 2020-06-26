package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		if(action == null) {
			
			req.getRequestDispatcher("/WEB-VIEW/home.jsp").forward(req, resp);
			
		} else if(action.equals("login")) {
			
			//Set null values for input and error message
			HttpSession session = req.getSession();
			
			Account account = new Account("", "");
			session.setAttribute("account", account);
			req.setAttribute("message", "");
			
			req.getRequestDispatcher("/WEB-VIEW/login.jsp").forward(req, resp);
		} else if(action.equals("register")) {
			
			req.getRequestDispatcher("/WEB-VIEW/register.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		if(action == null) {
			
			req.getRequestDispatcher("/WEB-VIEW/home.jsp").forward(req, resp);
		} 
		
		else if(action.equals("dologin")) {
			
			//Get Para from request Obj
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String remember = req.getParameter("rememberme");
			
			//Get values from Context Param
			String emailCheck = getServletContext().getInitParameter("email");
			String passCheck = getServletContext().getInitParameter("password");
			
			//Set Sessions && Cookies
			HttpSession session = req.getSession();
			Account account = new Account(email, password);
			
			//Set cookies
			Cookie userCookie = new Cookie("email", email);
			userCookie.setMaxAge(30);
			Cookie pwdCookie = new Cookie("password", password);
			pwdCookie.setMaxAge(30);
			
			if(account.validate() && email.equals(emailCheck) && password.equals(passCheck) && remember == null) {
				
				//Login successfully
				int index = email.indexOf("@");
				String welcome = "Welcome " + email.substring(0, index) + "!";
				session.setAttribute("welcomemessage", welcome);
				
				req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
				
			} else if(account.validate() && email.equals(emailCheck) && password.equals(passCheck) && remember != null) {
				
				//Add Cookies
				resp.addCookie(userCookie);
				resp.addCookie(pwdCookie);
				
				//Set welcome message
				int index = email.indexOf("@");
				String welcome = "Welcome " + email.substring(0, index) + "!";
				session.setAttribute("welcomemessage", welcome);
				
				req.getRequestDispatcher("/admin/index.jsp").forward(req, resp);
				
			} else if(!account.validate()) {
				
				//Invalid message
				session.setAttribute("account", account);
				req.setAttribute("message", account.getMessage());
				req.getRequestDispatcher("/WEB-VIEW/login.jsp").forward(req, resp);
				
			} else {
				
				//Wrong information
				session.setAttribute("account", account);
				req.setAttribute("message", "Your account information is not correct");
				req.getRequestDispatcher("/WEB-VIEW/login.jsp").forward(req, resp);
			} 
			
		}
		
	}

}
