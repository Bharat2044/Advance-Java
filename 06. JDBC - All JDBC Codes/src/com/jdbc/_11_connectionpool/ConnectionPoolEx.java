package com.jdbc._11_connectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPoolEx {
    private static Connection con = null;
    private static Statement stmt = null;

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "test";

    public static void main(String[] args) {
        DataSource dataSource = initializeDataSource();

        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            String query = "INSERT INTO `accounts` (`account_number`, `account_holder_name`, `account_balance`) VALUES (33003011, 'PAVAN', 2100.0)";
            int i = stmt.executeUpdate(query);

            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static DataSource initializeDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USERNAME);
        config.setPassword(PASSWORD);

        config.setMaximumPoolSize(10);
        config.setMaxLifetime(60000);
        config.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }
}
