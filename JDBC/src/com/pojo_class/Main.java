package com.pojo_class;

public class Main {
	public static void main(String[] args) {
		
		Person obj1 = new Person();		
		System.out.println(obj1.toString());
		
		obj1.setFirstName("Bharat");
		obj1.setLastName("Kumar");
		obj1.setAge(21);
		System.out.println(obj1.toString());
		System.out.println(obj1.getFirstName());
		System.out.println(obj1.getLastName());
		System.out.println(obj1.getAge());
		
		Person obj2 = new Person("Raj", "Singh", 29);		
		System.out.println(obj2.toString());
		
		System.out.println(obj2.getFirstName());
		System.out.println(obj2.getLastName());
		System.out.println(obj2.getAge());
		
		obj2.setFirstName("Mohan");
		obj2.setLastName("Thakur");
		obj2.setAge(37);		
		
		System.out.println(obj2.toString());
	}
}
