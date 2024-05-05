package com.jdbc._09_acid_properties_or_transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Transactions {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static Scanner scan = null;

    private static final String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private static final String username = "root";
    private static final String password = "test";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);    // Transaction Begin

            scan = new Scanner(System.in);
            System.out.print("Enter the Sender Account Number: ");
            int fromAccount = scan.nextInt();

            System.out.print("Enter the Receiver Account Number: ");
            int toAccount = scan.nextInt();

            System.out.print("Enter the Amount: ");
            double amount = scan.nextDouble();

            boolean flag = transferFunds(fromAccount, toAccount, amount);

            if (flag) {
                con.commit();    // Transaction Success
                System.out.println("Transaction successful!! Money transferred");
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback();    // Transaction Failed
                    System.out.println("Transaction Failed!! Money not transferred");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
                if (scan != null) {
                    scan.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean transferFunds(int fromAccount, int toAccount, double amount) {
        try {
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT `account_balance` FROM `accounts` WHERE `account_number` = " + fromAccount);
            if (rs.next()) {
                double balFromAccount = rs.getDouble("account_balance");

                rs.close();

                rs = stmt.executeQuery("SELECT `account_balance` FROM `accounts` WHERE `account_number` = " + toAccount);
                if (rs.next()) {
                    double balToAccount = rs.getDouble("account_balance");

                    stmt.executeUpdate("UPDATE `accounts` SET `account_balance` = " + (balFromAccount - amount) + " WHERE `account_number` = " + fromAccount);
                    stmt.executeUpdate("UPDATE `accounts` SET `account_balance` = " + (balToAccount + amount) + " WHERE `account_number` = " + toAccount);

                    if (balFromAccount - amount >= 0) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
