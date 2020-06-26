package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	public Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	private final String serverName = "127.0.0.1";
	private final String portNumber = "3306";
	private final String dbName = "shoppingdb";
	private final String userName = "admin";
	private final String password = "@dMin123";

}
