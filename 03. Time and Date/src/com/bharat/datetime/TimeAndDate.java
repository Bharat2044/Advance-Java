package com.bharat.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeAndDate {

	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		System.out.println("Date = " + ld);
		System.out.println("Year = " + ld.getYear());
		System.out.println("Month = " + ld.getMonth());
		System.out.println("Month Value = " + ld.getMonthValue());
		System.out.println("Day of Month = " + ld.getDayOfMonth());
		System.out.println("Day of Week = " + ld.getDayOfWeek());
		System.out.println("Day of Year = " + ld.getDayOfYear());
		
		LocalTime lt = LocalTime.now();
		System.out.println("\nTime = " + lt);
		System.out.println("Hour = " + lt.getHour());
		System.out.println("Minute = " + lt.getMinute());
		System.out.println("Second = " + lt.getSecond());
		System.out.println("Nano = " + lt.getNano());
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("\nDate and Time = " + ldt);
		
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
