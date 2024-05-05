package com.jdbc._03_crud_operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOpreations {
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String password = "test";
		
		String insertSql = "INSERT INTO `employee` " 
				+ "(`id`, `name`, `email`, `dept`, `salary`) VALUES " 
				+ "(8, 'mike', 'mike@gmail.com', 'IT', 99000)";
		String updateSql = "UPDATE `employee` " 
				+ "SET `salary` = `salary` + 5000 " 
				+ "WHERE `dept` = 'Finance'";
		String deleteSql = "DELETE FROM `employee` WHERE `id` = 3";
		
		try {
			// Loading the JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Establish a Connection to Database
			connection = DriverManager.getConnection(url, username, password);
			
			// Creating Statement
			statement = connection.createStatement();
			
			// CRUD Operations -> Create, Read, Update, Delete
			// Create -> insert a row in employee table
			/*
			int i = statement.executeUpdate(insertSql);
			System.out.println(i);
			*/
			
			// Update -> update a row of employee table
			int j = statement.executeUpdate(updateSql);
			System.out.println(j);
			
			// Delete -> delete a row from employee table
			int k = statement.executeUpdate(deleteSql);
			System.out.println(k);
			
			// Read -> Executing Queries: printing the employee table data
			result = displayEmployees(statement); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			close(connection, statement, result);
		}
	}

	public static ResultSet displayEmployees(Statement stmt) throws SQLException {
		ResultSet result = stmt.executeQuery("SELECT * FROM employee");										 
		
		while(result.next()) {
			System.out.println(result.getInt("id") + "  " +
					result.getString("name") + "  " + 
					result.getString("email") + "  " +
					result.getString("dept") + "  " +
					result.getInt("salary"));
		}
		
		return result;
	}

	private static void close(Connection connection, Statement statement, ResultSet result) {
		try {
			if(result != null) {
				result.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(statement != null) {
				statement.close();
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
