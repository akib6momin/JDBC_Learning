package com.akib.jdbc.learning;
import java.sql.*;
import java.util.Scanner;

public class Project11 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			// execute query
			String sql = "update studentinfo set age = ? where roll=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, 20);
			pstmt.setInt(2, 1);
			pstmt.addBatch();
			pstmt.setInt(1, 21);
			pstmt.setInt(2, 2);
			
			pstmt.executeBatch();
			
			System.out.println("See Updation In Database");
			
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
