package com.lazy_initialization;

public class LazySingletonSimple {
	// Private static instance variable
    private static LazySingletonSimple instance;

    // Private constructor to prevent instantiation from outside the class
    private LazySingletonSimple() {
        // Initialization code if needed
    }

    // Public method to get the instance of the singleton class
    public static LazySingletonSimple getInstance() {
        // Lazy initialization: create the instance only if it's null
        if (instance == null) {
            instance = new LazySingletonSimple();
        }
        return instance;
    }

    // Other methods of the singleton class
    public void someMethod() {
        System.out.println("Executing some method in LazySingletonSimple class.");
    }


	// Example usage in a main method
    public static void main(String[] args) {
    	// Using Simple Lazy Initialization
        LazySingletonSimple simpleInstance1 = LazySingletonSimple.getInstance();
        LazySingletonSimple simpleInstance2 = LazySingletonSimple.getInstance();

    	// Both instances should refer to the same object
        System.out.println("Simple Lazy Initialization: " + (simpleInstance1 == simpleInstance2)); // true
    
        // Using the LazySingletonSimple instance
        simpleInstance1.someMethod();
        simpleInstance2.someMethod();
	}  
}
