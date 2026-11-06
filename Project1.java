package com.akib.jdbc.learning;

import java.sql.*;

public class Project1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		// load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// establish the connection
		String url = "jdbc:mysql://localhost:3306/jdbc_learning";
		String user = "root";
		String pass = "Akib@123";
		
		Connection connect=DriverManager.getConnection(url, user, pass);
		
		// create the statement
		Statement stmt = connect.createStatement();
		
		// execute queries
		
		String sql = "INSERT INTO studentinfo(roll, name, age, city) VALUES(1, 'John', 21, 'London')";
		int rowsAffected = stmt.executeUpdate(sql);
		
		// process result
		if(rowsAffected==0) {
			System.out.println("Unable to insert records");
		}else {
			System.out.println("Records inserted successfully");
		}
		
		//close the resources
		stmt.close();
		connect.close();

	}

}
