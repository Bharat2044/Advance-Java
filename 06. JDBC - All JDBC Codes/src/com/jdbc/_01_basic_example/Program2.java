package com.jdbc._01_basic_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {
	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet result = null;
		
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String password = "test";
		
		try {
			// Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish Connection to Database
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
			
			// Create a SQL Operations
			stmt = connection.createStatement();
			
			/*
			// Execute the SQL Statement
			result = stmt.executeQuery("SELECT * FROM employee");										
			
			// Process the Result
			while(result.next()) {
				System.out.println(result.getInt("id") + "  " +
						result.getString("name") + "  " + 
						result.getString("email") + "  " +
						result.getString("dept") + "  " +
						result.getInt("salary"));
			} 
			*/
			
			result = displayEmployees(stmt); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Close the Connection	
			/*
			try {
				if(result != null) {
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			*/
			
			close(connection, stmt, result);
		}
	}

	public static ResultSet displayEmployees(Statement stmt) throws SQLException {
		ResultSet result;
		result = stmt.executeQuery("SELECT * FROM employee");										 
		
		while(result.next()) {
			System.out.println(result.getInt("id") + "  " +
					result.getString("name") + "  " + 
					result.getString("email") + "  " +
					result.getString("dept") + "  " +
					result.getInt("salary"));
		}
		
		return result;
	}

	private static void close(Connection connection, Statement stmt, ResultSet result) {
		try {
			if(result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
