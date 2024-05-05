package com.eager_initialization;

public class EagerSingleton {
    // Private static final instance variable (eagerly initialized)
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation from outside the class
    private EagerSingleton() {
        // Initialization code if needed
    }

    // Public method to get the instance of the singleton class
    public static EagerSingleton getInstance() {
        return instance;
    }

    // Other methods of the singleton class
    public void someMethod() {
        System.out.println("Executing some method in EagerSingleton class.");
    }
    
    
    // Example usage in a main method
    public static void main(String[] args) {
    	// Using Eager Initialization
        EagerSingleton eagerInstance1 = EagerSingleton.getInstance();
        EagerSingleton eagerInstance2 = EagerSingleton.getInstance();


    	// Both instances should refer to the same object
        System.out.println("Eager Initialization: " + (eagerInstance1 == eagerInstance2)); // true
    
        // Using the EagerSingleton instance
        eagerInstance1.someMethod();
        eagerInstance2.someMethod();
	}    
}