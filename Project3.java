package com.akib.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Project3 {

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
		
		String sql = "SELECT * FROM studentinfo";
		ResultSet rs = stmt.executeQuery(sql);
		
		
		// process result
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " "+ rs.getString(2) + " "+ rs.getInt(3) + " "+ rs.getString(4));
		}
		
		//close the resources
		stmt.close();
		connect.close();

	}

}
