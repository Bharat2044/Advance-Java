package com.bharat.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeesBean {

	public List<Employee> fetchEmployees() {

		List<Employee> listEmployees = new ArrayList<>();

		String dbURL = "jdbc:mysql://localhost:3306/jdbc_db";
		String dbUname = "root";
		String dbPassword = "test";

		try (Connection con = DriverManager.getConnection(dbURL, dbUname, dbPassword);
				Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery("SELECT * FROM `emp`");

			while (rs.next()) {
				Employee e = new Employee();
				e.setEmpNo(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setSalary(rs.getDouble(3));

				listEmployees.add(e);
			}

			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEmployees;
	}
}
