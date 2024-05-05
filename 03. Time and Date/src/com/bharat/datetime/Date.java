package com.bharat.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Date {

	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		System.out.println("Date = " + ld);
		System.out.println("Year = " + ld.getYear());
		System.out.println("Month = " + ld.getMonth());
		System.out.println("Month Value = " + ld.getMonthValue());
		System.out.println("Day of Month = " + ld.getDayOfMonth());
		System.out.println("Day of Week = " + ld.getDayOfWeek());
		System.out.println("Day of Year = " + ld.getDayOfYear());

		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("\nDate and Time = " + ldt);
		
		System.out.println("\nYear = " + ldt.getYear());
		System.out.println("Month = " + ldt.getMonth());
		System.out.println("Month Value = " + ldt.getMonthValue());
		System.out.println("Day of Month = " + ldt.getDayOfMonth());
		System.out.println("Day of Week = " + ldt.getDayOfWeek());
		System.out.println("Day of Year = " + ldt.getDayOfYear());
		

		System.err.println("\nDate and Time = " + ldt);
	}
}
