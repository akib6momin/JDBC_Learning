package com.akib.jdbc.learning;

import java.sql.*;

public class Project4 {

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
		
		String sql = "DELETE FROM studentinfo WHERE roll = 2";
		int rowsAffected = stmt.executeUpdate(sql);
		
		
		
		// process result
		
		if(rowsAffected==0) {
			System.out.println("Something went wrong");
		}else {
			System.out.println("Deleted Successfully");
		}
		
		//close the resources
		stmt.close();
		connect.close();

	}

}
