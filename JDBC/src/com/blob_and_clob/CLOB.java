package com.blob_and_clob;

import java.sql.Statement;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CLOB {
	private static Connection connection = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet result = null;
	
	private static final Scanner scan  = new Scanner(System.in);
	
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
	private static final String username = "root";
	private static final String password = "test";

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			connection = DriverManager.getConnection(url, username, password);
			
			pstmt = connection.prepareStatement("UPDATE `employee` SET `intro` = ? WHERE `id` = ?");

			FileReader fis = new FileReader("D:\\Full Stack Java Code\\JDBC\\myIntro.txt");
			pstmt.setCharacterStream(1, fis);
			
			System.out.print("Enter the Employee Id: ");
			pstmt.setInt(2, scan.nextInt());
			
			int i = pstmt.executeUpdate();
			System.out.println(i);
			

			stmt = connection.createStatement();
			result = BLOB.displayEmployees(stmt);
			
		}  catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            close();
        }
		
	}

	public static void close() {
		try {
			if (result != null) {
		        result.close();
		    }
		    if (stmt != null) {
		        stmt.close();
		    }
		    if (pstmt != null) {
		        pstmt.close();
		    }
		    if (connection != null) {
		        connection.close();
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	

	public static ResultSet displayEmployees(Statement stmt) throws SQLException {
		ResultSet result = stmt.executeQuery("SELECT * FROM employee");
		
		System.out.println("\n--------------------------------------------------------------------------------------------");
		while(result.next()) {
		    int id = result.getInt("id");
		    String name = result.getString("name");
		    String email = result.getString("email");
		    String dept = result.getString("dept");
		    int salary = result.getInt("salary");
		    InputStream dp = result.getBinaryStream("dp");
		    Reader longText = result.getCharacterStream("intro");
		    
		    System.out.printf("| %-2d | %-8s | %-20s | %-8s | %-2d |", id, name, email, dept, salary);

		    // Check if there is an image (assuming 'dp' is the column for the image)
		    if(dp != null){
		        System.out.print(" Image: [Present]     | ");
		    } else {
		        System.out.print(" Image: [Not Present] | ");
		    }
		     
		    // Print the text from the Reader
		    System.out.print(longText);

		    System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------------------\n");

		return result;
	}
}


