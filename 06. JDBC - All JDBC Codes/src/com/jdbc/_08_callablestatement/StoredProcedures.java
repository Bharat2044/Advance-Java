package com.jdbc._08_callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class StoredProcedures {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static CallableStatement cstmt = null;
	private static ResultSet res = null;
	
	private static final Scanner scan  = new Scanner(System.in);
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";

	public static void main(String[] args) {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			connection = DriverManager.getConnection(url, username, password);
			
			/*
			String query = "{ CALL experience_of_user(?, ?) }";
			cstmt = connection.prepareCall(query);
			
			System.out.print("Enter the user number: ");
			int uno = scan.nextInt();
			cstmt.setInt(1, uno);
			cstmt.registerOutParameter(2, Types.DOUBLE);
			
			cstmt.execute();
			double ans = cstmt.getDouble(2);
			
			if(ans != 0) {
				System.out.println("Experience of user number " + uno + " in years = " + ans);
			} else {
				System.out.println("User number " + uno + " users not found");
			}
			*/
			
			
			String query = "SELECT DATEDIFF(CURDATE(), hire_date)/365 AS experience FROM users WHERE user_no = ?";
            pstmt = connection.prepareStatement(query);

            System.out.print("Enter the user number: ");
            int uno = scan.nextInt();            
            pstmt.setInt(1, uno);

            res = pstmt.executeQuery();

            if (res.next()) {
                double ans = res.getDouble("experience");
                System.out.println("Experience of user number " + uno + " in years = " + ans);
            } else {
                System.out.println("User number " + uno + " not found");
            }            			
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(res != null) {
					res.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(cstmt != null) {
					cstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

