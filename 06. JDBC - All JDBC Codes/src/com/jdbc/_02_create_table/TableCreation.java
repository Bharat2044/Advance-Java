package com.jdbc._02_create_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation {
    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_db";
        String username = "root";
        String password = "test";

        String query = "CREATE TABLE test(id INT, name VARCHAR(45), age INT, salary DOUBLE)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            boolean x = statement.execute(query);

            if (!x) {
                System.out.println("Table created successfully");
            } else {
            	System.out.println("Failed, tabled not created or already exists");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
