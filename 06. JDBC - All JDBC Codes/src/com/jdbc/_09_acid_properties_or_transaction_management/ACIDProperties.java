package com.jdbc._09_acid_properties_or_transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ACIDProperties {
	private static Connection con = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet res = null;
	
	private static final Scanner scan  = new Scanner(System.in);
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			ACIDProperties.displayEmployees(con);
			
			con.setAutoCommit(false);
			transaction();
			
			ACIDProperties.displayEmployees(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, pstmt, res);
		}
	}

	// taking input for transaction
	private static void transaction() throws SQLException {
		System.out.println("Enter Sender Name: ");
		String sender = scan.next();
		
		System.out.println("Enter Reciever Name: ");
		String reciever = scan.next();
		
		System.out.println("Enter Amount: ");
		int amount = scan.nextInt();
		
		int x = updateBalance(sender, -amount);
		int y = updateBalance(reciever, amount);
		//System.out.println(x + "  " + y);
		
		if (isConfirm(x, y)) {
			System.out.println("Transaction Successful...");
			con.commit();
		} else {
			System.out.println("Transaction Failed...");
			con.rollback();
		}
	}
	
	// helper method -> it will conform transaction
	private static boolean isConfirm(int x, int y) {
		System.out.println("Do you want this transaction? (yes/no): ");
		String choice = scan.next();
		
		return (choice.equalsIgnoreCase("yes") && (x == 1) && (y == 1));
	}

	// updating balance
	private static int updateBalance(String user, int amount) throws SQLException {
		String sql = "UPDATE `employee` SET `salary` = `salary` + ? WHERE `name` = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, amount);
		pstmt.setString(2, user);
		
		int i = pstmt.executeUpdate();
		return i;
	}

	// printing all employee details
	public static void displayEmployees(Connection con) throws SQLException {
		stmt = con.createStatement();
		
		res = stmt.executeQuery("SELECT * FROM `employee`");										 
		
		System.out.println("\n------------------------------------------------------------");
		while(res.next()) {
			System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-6d |", 
					res.getInt("id"), 
					res.getString("name"), 
					res.getString("email"), 
					res.getString("dept"), 
					res.getInt("salary"));
			System.out.println();
		}
		
		System.out.println("------------------------------------------------------------\n");
	}
	
	private static void close(Connection con, Statement stmt, PreparedStatement pstmt, ResultSet res) {
		try {
			if(res != null) {
				res.close();
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
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}