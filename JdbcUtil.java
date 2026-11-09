package com.akib.jdbc.learning;
import java.sql.*;

public class JdbcUtil {
	
	static {
		// load or register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc_learning";
		String user = "root";
		String pass = "Akib@123";
		
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void closeResources(Connection con, Statement stmt) throws SQLException {
		con.close();
		stmt.close();
	}
}
