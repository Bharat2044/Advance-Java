package com.jdbc._07_batch_processing;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class BatchProcessing {
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet res = null;
	
	private final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {		
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String password = "test";
		
		String updateSql = "UPDATE `employee` "
						+ "SET `salary` = `salary` + ? "
						+ "WHERE `dept` = ?";
		String insertSql = "INSERT INTO `employee` " 
				+ "(`id`, `name`, `email`, `dept`, `salary`) VALUES " 
				+ "(?, ?, ?, ?, ?)";
		String deleteSql = "DELETE FROM `employee` WHERE `id` = ?";
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			displayEmployees(statement);
			
			// Update multipla salary of employee table ->  input given by user both salary and department
			/*
			String choice = null;
			do {								
				System.out.println("Enter Salary: ");
				int salary = scan.nextInt();
				
				System.out.println("Enter Department: ");
				String dept = scan.next();
				
				String query = "UPDATE `employee` SET `salary` = `salary` + '" + salary + "' WHERE `dept` = '" + dept + "'";
				
				statement.addBatch(query);
				
				System.out.print("Do you want to update more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr1 = statement.executeBatch();
			System.out.println(Arrays.toString(arr1));
			*/
			/*
			pstmt = connection.prepareStatement(updateSql);			
			String choice = null;
			do {								
				System.out.println("Enter Salary: ");
				pstmt.setInt(1, scan.nextInt());
				
				System.out.println("Enter Department: ");
				pstmt.setString(2, scan.next());
				
				pstmt.addBatch();
				
				System.out.print("Do you want to update more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr1 = pstmt.executeBatch();
			System.out.println(Arrays.toString(arr1));
			*/
			
			
			// Insert multiple row in employee table -> all input from user		
			/*
			String choice = null;
			do {				
				System.out.println("Enter Id: ");
				int id = scan.nextInt();
				
				System.out.println("Enter Name: ");
				String name = scan.next();
				
				System.out.println("Enter Email: ");
				String email = scan.next();
				
				System.out.println("Enter Department: ");
				String dept = scan.next();
				
				System.out.println("Enter Salary: ");
				int salary = scan.nextInt();
				
				String query = "INSERT INTO `employee` (`id`, `name`, `email`, `dept`, `salary`) VALUES('"+id+"', '"+name+"', '"+email+"', '"+dept+"', '"+salary+"')";
				
				statement.addBatch(query);
				
				System.out.print("Do you want to enter more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr2 = statement.executeBatch();
			System.out.println(Arrays.toString(arr2));
			*/
			/*
			pstmt = connection.prepareStatement(insertSql);
			String choice = null;
			do {				
				System.out.println("Enter Id: ");
				pstmt.setInt(1, scan.nextInt());
				
				System.out.println("Enter Name: ");
				pstmt.setString(2, scan.next());

				System.out.println("Enter Email: ");
				pstmt.setString(3, scan.next());

				System.out.println("Enter Department: ");
				pstmt.setString(4, scan.next());

				System.out.println("Enter Salary: ");
				pstmt.setInt(5, scan.nextInt());
				
				pstmt.addBatch();
				
				System.out.print("Do you want to enter more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr2 = pstmt.executeBatch();
			System.out.println(Arrays.toString(arr2));
			*/
			
			
			// Delete multiple row base on id -> input given by user
			/*
			String choice = null;
			do {								
				System.out.print("Enter Id: ");
				int id = scan.nextInt();
				
				String query = "DELETE FROM `employee` WHERE `id` = '" + id + "'";
				
				statement.addBatch(query);
				
				System.out.print("Do you want to delete more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr3 = statement.executeBatch();
			System.out.println(Arrays.toString(arr3));
			*/
			
			pstmt = connection.prepareStatement(deleteSql);
			String choice = null;
			do {								
				System.out.print("Enter Id: ");
				pstmt.setInt(1, scan.nextInt());
				
				pstmt.addBatch();
				
				System.out.print("Do you want to delete more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
			int[] arr3 = pstmt.executeBatch();
			System.out.println(Arrays.toString(arr3));
			
			displayEmployees(statement);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  finally {			
			close(connection, statement, pstmt, res);
		}
	}
	
	public static void displayEmployees(Statement stmt) throws SQLException {
		ResultSet result = stmt.executeQuery("SELECT * FROM `employee`");										 
		
		System.out.println("\n------------------------------------------------------------");
		while(result.next()) {
			System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-6d |", 
					result.getInt("id"), 
					result.getString("name"), 
					result.getString("email"), 
					result.getString("dept"), 
					result.getInt("salary"));
			System.out.println();
		}
		
		System.out.println("------------------------------------------------------------\n");
		result.close();
	}

	private static void close(Connection connection, Statement statement, PreparedStatement pstmt, ResultSet res) {
		try {
			if(res != null) {
				res.close();
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
			if(pstmt != null) {
				pstmt.close();
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

