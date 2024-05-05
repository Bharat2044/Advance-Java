package com.lazy_initialization;

public class BillPughSingleton {

    // Private constructor to prevent instantiation from outside the class
    private BillPughSingleton() {
        // Initialization code if needed
    }

    // Static inner helper class to hold the singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public method to get the instance of the singleton class
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Other methods of the singleton class
    public void someMethod() {
        System.out.println("Executing some method in BillPughSingleton class.");
    }
    
    
    // Example usage in a main method
    public static void main(String[] args) {
    	// Using Bill Pugh Singleton
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = BillPughSingleton.getInstance();

        // Check if both instances refer to the same object
        System.out.println("Instances are equal: " + (instance1 == instance2)); // true

        // Using the singleton instances
        instance1.someMethod();
        instance2.someMethod();
	}
}
