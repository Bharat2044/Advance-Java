package com.jdbc._05_resultsetmetadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataExample {
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static ResultSetMetaData rsmd = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";

	
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			
			//rs = stmt.executeQuery("SELECT * FROM `employee`");		
			rs = stmt.executeQuery("SELECT `id`, `name`, `dept` FROM `employee`");		
			
			rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			
			for(int i = 1; i <= columnCount; i++) {
				System.out.println("Column Number    : " + i);
				System.out.println("Column Name      : " + rsmd.getColumnName(i));
				System.out.println("Column Type Name : " + rsmd.getColumnTypeName(i));
				System.out.println("Column Size 	 : " + rsmd.getColumnDisplaySize(i));
				System.out.println("isNullable 	 : " + rsmd.isNullable(i));
				System.out.println("=================================================");
			}
			
			displayEmployees(stmt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  finally {			
			close();
		}
	}
	
	public static void displayEmployees(Statement stmt) throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM `employee`");										 
		
		System.out.println("\n-----------------------------------------------------------");
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