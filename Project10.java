package com.akib.jdbc.learning;
import java.sql.*;
import java.util.Scanner;

public class Project10 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			// execute query
			String sql = "select * from studentinfo where roll=?";
			pstmt = con.prepareStatement(sql);
			
			System.out.println("======Enter The Data Required======");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Roll No Of Student Whose Data Want To Reterive : ");
			int roll = scan.nextInt();
			
			
			pstmt.setInt(1, roll);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rollno = rs.getInt("roll");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String city = rs.getString("city");
				
				System.out.println(rollno + " " + name +" " + age + " " + city);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.closeResources(con, pstmt);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
