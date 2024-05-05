package com.bharat.datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Time {

	public static void main(String[] args) {
		
		LocalTime lt = LocalTime.now();
		System.out.println("Time = " + lt);
		System.out.println("Hour = " + lt.getHour());
		System.out.println("Minute = " + lt.getMinute());
		System.out.println("Second = " + lt.getSecond());
		System.out.println("Nano = " + lt.getNano());
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("\nDate and Time = " + ldt);
		
		System.out.println("\nHour = " + ldt.getHour());
		System.out.println("Minute = " + ldt.getMinute());
		System.out.println("Second = " + ldt.getSecond());
		System.out.println("Nano = " + ldt.getNano());
		
		System.err.println("\nDate and Time = " + ldt);
	}
}
