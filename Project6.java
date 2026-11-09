package com.akib.jdbc.learning;

import java.sql.*;

public class Project6 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create the connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc_learning";
			String user = "root";
			String pass = "Akib@123";
			con = DriverManager.getConnection(url, user, pass);
			
			// create statement
			stmt = con.createStatement();
			
			// execute query 
			String sql = "SELECT * FROM studentinfo";
			rs = stmt.executeQuery(sql);
			
			// process the result
			while(rs.next()) {
				System.out.println(rs.getInt("roll") + " " + rs.getString("name") +" " + rs.getInt("age") + " " + rs.getString("city"));
			}
			
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// close the connection
			try {
				con.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
