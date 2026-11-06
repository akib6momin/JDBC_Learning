package com.akib.jdbc.learning;

import java.sql.*;

public class Project1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		// load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// establish the connection
		String url = "mysql:jdbc://localhost:3306/jdbc_learning";
		String user = "localhost";
		String pass = "Akib@123";
		
		Connection connect=DriverManager.getConnection(url, user, pass);
		
		// create the statement
		Statement stmt = connect.createStatement();
		
		// execute queries
		
		// process result
		
		//close the resources
		stmt.close();
		connect.close();

	}

}
