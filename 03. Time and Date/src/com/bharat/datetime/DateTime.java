package com.bharat.datetime;

import java.time.LocalDateTime;

public class DateTime {
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Date and Time = " + ldt);
		
		System.out.println("\nYear = " + ldt.getYear());
		System.out.println("Month = " + ldt.getMonth());
		System.out.println("Month Value = " + ldt.getMonthValue());
		System.out.println("Day of Month = " + ldt.getDayOfMonth());
		System.out.println("Day of Week = " + ldt.getDayOfWeek());
		System.out.println("Day of Year = " + ldt.getDayOfYear());
		
		System.out.println("\nHour = " + ldt.getHour());
		System.out.println("Minute = " + ldt.getMinute());
		System.out.println("Second = " + ldt.getSecond());
		System.out.println("Nano = " + ldt.getNano());
		
		System.err.println("\nDate and Time = " + ldt);
	}
}
