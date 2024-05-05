package com.jdbc._08_callablestatement;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatementExample {
	private static Connection connection = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static CallableStatement cstmt = null;
	
	private static final Scanner scan  = new Scanner(System.in);
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";

	public static void main(String[] args) {
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			connection = DriverManager.getConnection(url, username, password);
			
			
			// 1. Count number of employees of a specific department
			/*
			cstmt = connection.prepareCall("{call count_emp_dept(?, ?)}");
			
			System.out.print("Enter the department name: ");
			cstmt.setString(1, scan.next());
			cstmt.registerOutParameter(2, Types.INTEGER);

			cstmt.execute();
			int ans = cstmt.getInt(2);			 
			System.out.println("Employee Count = " + ans);
			*/
			/*
			stmt = connection.createStatement();			
			System.out.print("Enter the department name: ");
			String dep = scan.next();
			
			String sql = "SELECT COUNT(*) FROM `employee` WHERE `dept` = '"+ dep +"'";
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("Employee Count = " + count);
			}
			*/
			/*
			String sql = "SELECT COUNT(*) FROM `employee` WHERE `dept` = ?";
			pstmt = connection.prepareStatement(sql);
			
			System.out.println("Enter the Salary: ");
			pstmt.setString(1, scan.next());
			
			ResultSet result = pstmt.executeQuery();
			
			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("Employee Count = " + count);
			}
			*/
			
			// 2. Count number of employees having salary greater than a specific salary
			/*
			cstmt = connection.prepareCall("{call count_emp_salary(?)}");
			
			System.out.print("Enter the Salary: ");
			cstmt.setInt(1, scan.nextInt());
			cstmt.registerOutParameter(1, Types.INTEGER);

			cstmt.execute();
			
			int ans = cstmt.getInt(1);			 
			System.out.println("Employee Count = " + ans);
			*/
			
			/*
			stmt = connection.createStatement();			
			System.out.println("Enter the Salary: ");
			int sal = scan.nextInt();
			
			String sql = "SELECT COUNT(*) FROM `employee` WHERE `salary` > '"+ sal +"'";
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("Employee Count = " + count);
			}
			*/
			/*
			String sql = "SELECT COUNT(*) FROM `employee` WHERE `salary` > ?";
			pstmt = connection.prepareStatement(sql);
			
			System.out.println("Enter the Salary: ");
			pstmt.setInt(1, scan.nextInt());
			
			ResultSet result = pstmt.executeQuery();
			
			while (result.next()) {
				int count = result.getInt(1);
				System.out.println("Employee Count = " + count);
			}
			*/
			
			
			// 3. Retrieve all employees having salary lesser than a specific amount
			cstmt = connection.prepareCall("{call display_emp(?)}");
			
			System.out.print("Enter the Salary: ");
			cstmt.setInt(1, scan.nextInt());

			cstmt.execute();
			ResultSet result = cstmt.getResultSet();
			
			/*
			stmt = connection.createStatement();
			System.out.print("Enter Salary: ");
			int sal = scan.nextInt();
			
			String sql = "SELECT * FROM `employee` WHERE `salary` < '"+ sal +"'";
			ResultSet result = stmt.executeQuery(sql);
			*/
			/*
			String sql = "SELECT * FROM `employee` WHERE `salary` < ?"; 
			pstmt = connection.prepareStatement(sql);
			
			System.out.println("Enter Salary: ");
			pstmt.setInt(1, scan.nextInt());
			
			ResultSet result = pstmt.executeQuery();
			*/
									
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
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

