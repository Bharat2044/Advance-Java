package com.lazy_initialization;

public class LazySingletonSynchronized {
    // Private static instance variable
    private static LazySingletonSynchronized instance;

    // Private constructor to prevent instantiation from outside the class
    private LazySingletonSynchronized() {
        // Initialization code if needed
    }

    // Public method to get the instance of the singleton class with synchronization
    public static synchronized LazySingletonSynchronized getInstance() {
        // Lazy initialization with synchronization: create the instance only if it's null
        if (instance == null) {
            instance = new LazySingletonSynchronized();  // Create a new instance if it doesn't exist
        }
        return instance;
    }

    // Other methods of the singleton class
    public void someMethod() {
        System.out.println("Executing some method in LazySingletonSynchronized class.");
    }
    
    
    // Example usage in a main method
    public static void main(String[] args) {
    	// Using Synchronized Lazy Initialization
        LazySingletonSynchronized synchronizedInstance1 = LazySingletonSynchronized.getInstance();
        LazySingletonSynchronized synchronizedInstance2 = LazySingletonSynchronized.getInstance();

        // Both instances should refer to the same object
        System.out.println("Synchronized Lazy Initialization: " + (synchronizedInstance1 == synchronizedInstance2)); // true

        // Using the LazySingletonSynchronized instance
        synchronizedInstance1.someMethod();
        synchronizedInstance2.someMethod();
	}
}

