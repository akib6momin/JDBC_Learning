package com.akib.jdbc.learning;
import java.sql.*;

import java.util.*;

public class Project7 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			// create connection
			con = JdbcUtil.getConnection();
			
			// execute the query
			
			String sql = "INSERT INTO studentinfo(roll, name, age, city) VALUES(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			
			System.out.println("======Enter The Data Required======");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Roll No: ");
			int roll = scan.nextInt();
			
			System.out.println("Enter Name: ");
			String name = scan.next();
			
			System.out.println("Enter Age: ");
			int age = scan.nextInt();
			
			System.out.println("Enter City: ");
			String city = scan.next();
			
			stmt.setInt(1, roll);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setString(4, city);
			
			int rowsAffected = stmt.executeUpdate();
			
			// process result
			
			if(rowsAffected==0) {
				System.out.println("Something went wrong");
			}else {
				System.out.println("Inserted Successfully");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeResources(con, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
