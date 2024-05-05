package com.jdbc._01_basic_example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_db";
		String username = "root";
		String password = "test"; 
		
		try {
			// 1. Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. Establish Connection to Database
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "test");
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println(con);
			
			// 3. Create a SQL Operations
			Statement stmt = con.createStatement();
			
			// 4. Execute the SQL Statement
			ResultSet result = stmt.executeQuery("SELECT * FROM employee");										  // Read
			
			// 5. Process the Result
			while(result.next()) {
				/*
				System.out.println(result.getString(1) + "  " +
						result.getString(2) + "  " + 
						result.getString(3) + "  " +
						result.getString(4) + "  " +
						result.getString(5));
				*/
				
				/*
				System.out.println(result.getInt(1) + "  " +
						result.getString(2) + "  " + 
						result.getString(3) + "  " +
						result.getString(4) + "  " +
						result.getInt(5));
				*/
				
				System.out.println(result.getInt("id") + "  " +
						result.getString("name") + "  " + 
						result.getString("email") + "  " +
						result.getString("dept") + "  " +
						result.getInt("salary"));
			} 
			
			// 6. Close the Connection
			con.close();
			stmt.close();
			result.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
