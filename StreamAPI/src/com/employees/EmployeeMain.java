package com.employees;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeMain {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("mike", 30, "chennai"),
				new Employee("stalin", 25, "chennai"),
				new Employee("adam", 34, "pune"),
				new Employee("sam", 34, "bengaluru")				
        );

        System.out.println(employees);
        
        for(Employee emp : employees) {
        	System.out.println(emp.getName() + "\t" + emp.getAge() + "\t" + emp.getCity());
        }
        
        System.out.println();
        
        // filter this employees based on age is greater than 30
        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
        System.out.println(emps);
        
        // printing using for-each loop
        for(Employee e : emps) {
        	System.out.println(e.getName() + "\t" + e.getAge() + "\t" + e.getCity());
        }
        
        System.out.println();
        
        // printing using forEach() method
        emps.forEach(e -> System.out.println(e.getName() + "\t" + e.getAge() + "\t" + e.getCity()));
	
        System.out.println();
        
        // grouping based on age
        Map<Integer, List<Employee>> groupedByAge = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
        System.out.println(groupedByAge); 
        
        for(Map.Entry<Integer, List<Employee>> entry : groupedByAge.entrySet()) {
        	Integer age = entry.getKey();
        	List<Employee> employeesWithAge = entry.getValue();
        	
        	// System.out.println("Employee With age: " + age + "  " + employeesWithAge);
        	
        	System.out.println("Employee With age: " + age + " ===> ");
        	for(Employee e : employeesWithAge) {
        		System.out.println("\t" + e.getName() + "\t" + e.getCity());
        	}
        }
        System.out.println();
        
        // grouping based on city
        Map<String, List<Employee>> groupedByCity = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        System.out.println(groupedByCity);     
        
        for(Map.Entry<String, List<Employee>> entry : groupedByCity.entrySet()) {
        	String city = entry.getKey();
        	List<Employee> employeesWithCity = entry.getValue();
        	
        	// System.out.println("Employee With city: " + city + "  " + employeesWithCity);
        	
        	System.out.println("Employee With city: " + city + " ===> ");
        	for(Employee e : employeesWithCity) {
        		System.out.println("\t" + e.getName() + "\t" + e.getAge());
        	}
        }
        
        System.out.println();        
        
	}
}
