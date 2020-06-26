package model;

public class Account {
	private String email = "";
	private String password = "";
	private String message = "";
	
	public Account() {
		
	}
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	
	public boolean validate() {
		
		if(!email.matches("^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$")) {
			this.message = "Invalid email address.";
			return false;
		} 
		
		else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
			this.message = "Invalid Password.";
			return false;
		}
		
		else {
			return true;
		}
		
	}
	
}

