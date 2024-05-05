package com.jdbc._06_preparedstatement;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementExample {
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet res = null;
	
	private final static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {		
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String password = "test";
		
		String readSql = "SELECT * FROM `employee` WHERE `dept` = ?";
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
			
			// Update salary of employee table ->  input given by user both salary and department
			/*
			System.out.println ("Enter the salary and department: ");
			String query = "UPDATE `employee` SET `salary` = `salary` + '" + scan.nextInt() + "' WHERE `dept` = '" + scan.next() + "'";
			int i = statement.executeUpdate(query);
			System.out.println(i);
			*/
			/*
			pstmt = connection.prepareStatement(updateSql);
			
			System.out.println("Enter the salary and department: ");
			pstmt.setInt(1, scan.nextInt());
			pstmt.setString(2, scan.next());
			
			int i = pstmt.executeUpdate();
			System.out.println(i);
			*/
			
			
			// Insert a row in employee table -> all input from user
			/*
			System.out.println("Enter the id, name, email, department and salary: ");
			int id = scan.nextInt();
			String name = scan.next();
			String email = scan.next();
			String dept = scan.next();
			int salary = scan.nextInt();
			String query = "INSERT INTO `employee` (`id`, `name`, `email`, `dept`, `salary`) VALUES('"+id+"', '"+name+"', '"+email+"', '"+dept+"', '"+salary+"')";
			int j = statement.executeUpdate(query);
			System.out.println(j);
			*/
			/*
			pstmt = connection.prepareStatement(insertSql);
			
			System.out.println("Enter the id, name, email, department and salary: ");
			pstmt.setInt(1, scan.nextInt());
			pstmt.setString(2, scan.next());
			pstmt.setString(3, scan.next());
			pstmt.setString(4, scan.next());
			pstmt.setInt(5, scan.nextInt());
			
			int j = pstmt.executeUpdate();
			System.out.println(j);
			*/
			
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
				
			 	int j = statement.executeUpdate(query);
			 	System.out.println(j);
				
				System.out.print("Do you want to enter more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			
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
				
				int j = pstmt.executeUpdate();
				System.out.println(j);
				
				System.out.print("Do you want to enter more employee? (yes/no): ");
				choice = scan.next();
			} while(choice.equalsIgnoreCase("yes"));
			*/
			
			
			// Delete a row base on id -> input given by user
			/*
			System.out.println("Enter the id you want to delete: ");
			String query = "DELETE FROM `employee` WHERE `id` = '" + scan.nextInt() + "'";
			int k = statement.executeUpdate(query);
			System.out.println(k);
			*/
			/*
			pstmt = connection.prepareStatement(deleteSql);
			
			System.out.println("Enter the id you want to delete: ");
			pstmt.setInt(1, scan.nextInt());
			
			int k = pstmt.executeUpdate();
			System.out.println(k);
			*/
			
			
			
			// Print row based on department input given by user
			/*			 
			System.out.print("Enter the department: ");
			String str = scan.next();
			String query = "SELECT * FROM `employee` WHERE `dept` = '" + str + "'";
			ResultSet res = statement.executeQuery(query);
			*/
			/*
			pstmt = connection.prepareStatement(readSql);
			
			System.out.print("Enter the department: ");
			pstmt.setString(1, scan.next());
			
			res = pstmt.executeQuery();
			
			System.out.println("-----------------------------------------------------------");
			while(res.next()) {
				System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
						res.getInt("id"), 
						res.getString("name"), 
						res.getString("email"), 
						res.getString("dept"), 
						res.getInt("salary"));
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------");
			*/
			
			displayEmployees(statement);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  finally {			
			close(connection, statement, pstmt, res);
		}
	}
	
	public static void displayEmployees(Statement stmt) throws SQLException {
		ResultSet result = stmt.executeQuery("SELECT * FROM `employee`");										 
		
		System.out.println("\n-----------------------------------------------------------");
		while(result.next()) {
			System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", 
					result.getInt("id"), 
					result.getString("name"), 
					result.getString("email"), 
					result.getString("dept"), 
					result.getInt("salary"));
			System.out.println();
		}
		
		System.out.println("-----------------------------------------------------------\n");
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
