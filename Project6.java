package com.akib.jdbc.learning;

import java.sql.*;

public class Project6 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			
			// create the connection
			con = JdbcUtil.getConnection();
			
			// create statement
			stmt = con.createStatement();
			
			// execute query 
			String sql = "SELECT * FROM studentinfo";
			rs = stmt.executeQuery(sql);
			
			// process the result
			while(rs.next()) {
				System.out.println(rs.getInt("roll") + " " + rs.getString("name") +" " + rs.getInt("age") + " " + rs.getString("city"));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// close the connection
			try {
				JdbcUtil.closeResources(con, stmt);
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
