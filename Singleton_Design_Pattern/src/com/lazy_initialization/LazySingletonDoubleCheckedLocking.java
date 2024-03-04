package com.lazy_initialization;

public class LazySingletonDoubleCheckedLocking {

    // Private static volatile instance variable for double-checked locking
    private static volatile LazySingletonDoubleCheckedLocking instance;

    // Private constructor to prevent instantiation from outside the class
    private LazySingletonDoubleCheckedLocking() {
        // Initialization code if needed
    }

    // Public method to get the instance of the singleton class with double-checked locking
    public static LazySingletonDoubleCheckedLocking getInstance() {
        // Double-checked locking: check if the instance is null before acquiring the lock
        if (instance == null) {
            synchronized (LazySingletonDoubleCheckedLocking.class) {
                // Double-checked locking: check again inside the synchronized block
                if (instance == null) {
                    instance = new LazySingletonDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }

    // Other methods of the singleton class
    public void performSomeAction() {
        System.out.println("Executing some action in LazySingletonDoubleCheckedLocking class.");
    }
    
    
    // Example usage in a main method
    public static void main(String[] args) {
    	// Using Lazy Initialization with Double-Checked Locking
        LazySingletonDoubleCheckedLocking instance1 = LazySingletonDoubleCheckedLocking.getInstance();
        LazySingletonDoubleCheckedLocking instance2 = LazySingletonDoubleCheckedLocking.getInstance();

        // Check if both instances refer to the same object
        System.out.println("Instances are equal: " + (instance1 == instance2)); // true

        // Using the singleton instances
        instance1.performSomeAction();
        instance2.performSomeAction();
	}
}
