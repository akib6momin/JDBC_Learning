package com.akib.jdbc.learning;

import java.sql.*;

public class Project2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String user = "root";
		String url ="jdbc:mysql://localhost:3306/jdbc_learning";
		String pass = "Akib@123";
		
		Connection con = DriverManager.getConnection(url, user, pass);
		
		Statement stmt = con.createStatement();
		
		String sql = "UPDATE studentinfo SET AGE = 24 WHERE roll = 1";
		
		int rowsAffected = stmt.executeUpdate(sql);
		
		if(rowsAffected==0) {
			System.out.println("Something went wrong");
		}else {
			System.out.println("Updated Successfully");
		}
	}

}
