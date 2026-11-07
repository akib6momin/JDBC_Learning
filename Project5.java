package com.akib.jdbc.learning;

import java.sql.*;

public class Project5 {

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
		
		String sql = "INSERT INTO studentinfo(roll, name, age, city) VALUES(2, 'Doe', 19, 'Pune')";
		
		boolean status = stmt.execute(sql);
		
		if(status) {
			// true means it is a select query
			System.out.println("This is Select query");
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println(rs.getInt("roll") + " " + rs.getString("name") +" " + rs.getInt("age") + " " + rs.getString("city"));
			}
			
		}else {
			// false means it is a non select query 
			System.out.println("This is Non Select query");
			int rowsAffected = stmt.getUpdateCount();
			if(rowsAffected==0) {
				System.out.println("Something went wrong");
			}else {
				System.out.println("Operation Completed Successfully");
			}
		}
		
		
		// process result
		
		
		//close the resources
		stmt.close();
		connect.close();

	}

}
