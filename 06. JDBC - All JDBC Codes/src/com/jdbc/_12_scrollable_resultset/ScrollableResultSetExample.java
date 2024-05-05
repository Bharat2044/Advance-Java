package com.jdbc._12_scrollable_resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSetExample {
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
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			// stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			rs = stmt.executeQuery("SELECT * FROM `employee`");
			
			/*
			 * Printing the all records from top to bottom / in forward order
			 */
			rs.beforeFirst();			
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
		
			
			/*
			 * Printing the all records from bottom to top / in reverse order
			 */
			rs.afterLast();			
			System.out.println("-----------------------------------------------------------");
			while(rs.previous()) {
				System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("dept"), 
						rs.getInt("salary"));
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------\n");

			
			/*
			 * Printing 4th row records
			 */
			rs.absolute(4);	
			System.out.println("-----------------------------------------------------------");
			System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
					rs.getInt("id"), 
					rs.getString("name"), 
					rs.getString("email"), 
					rs.getString("dept"), 
					rs.getInt("salary"));
			System.out.println();
			System.out.println("-----------------------------------------------------------\n");
			
			
			/*
			 * Printing the all records after 4rd row
			 */
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

			
			/*
			 * Printing the all records before 4rd row
			 */
			System.out.println("-----------------------------------------------------------");
			while(rs.previous()) {
				System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("dept"), 
						rs.getInt("salary"));
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------\n");
		
			
			/*
			 * Updateing 1st row 
			 */
			rs.next();
			rs.updateString(2, "alex");
			rs.updateString(3, "alex@gmail.com");
			rs.updateRow();
						
			/*
			 * Updateing 5th row 
			 */
			rs.absolute(5);
			rs.updateString("dept", "Account");
			rs.updateInt("salary", 38000);
			rs.updateRow();
			
			System.out.println("Row updated");
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