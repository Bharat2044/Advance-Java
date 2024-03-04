package com.resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExample {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";

	
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM `employee`");		
			
			System.out.println("-----------------------------------------------------------");
			while(rs.next()) {
				System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("dept"), 
						rs.getInt("salary"));
				System.out.println();
			}
			
			System.out.println("-----------------------------------------------------------\n");
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  finally {			
			close();
		}
	}

	private static void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}