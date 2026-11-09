package com.akib.jdbc.learning;
import java.sql.*;
import java.util.Scanner;

public class Project8 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			// execute query
			String sql = "update studentinfo set age = ? where roll=?";
			pstmt = con.prepareStatement(sql);
			
			System.out.println("======Enter The Data Required======");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Roll No Of Student Whose Age Want To Update : ");
			int roll = scan.nextInt();
			
			System.out.println("Enter Age: ");
			int age = scan.nextInt();
			
			pstmt.setInt(1, age);
			pstmt.setInt(2, roll);
			
			int rowsAffected = pstmt.executeUpdate();
			
			if(rowsAffected==0) {
				System.out.println("Something went wrong");
			}else {
				System.out.println("Updated Successfully");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeResources(con, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
