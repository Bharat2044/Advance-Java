package com.eager_initialization;

public class EagerSingletonWithStaticBlock {

    // Private static final instance variable (eagerly initialized in a static block)
    private static final EagerSingletonWithStaticBlock instance;

    // Static block for initialization
    static {
        try {
            instance = new EagerSingletonWithStaticBlock();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred during singleton instance creation");
        }
    }

    // Private constructor to prevent instantiation from outside the class
    private EagerSingletonWithStaticBlock() {
        // Initialization code if needed
    }

    // Public method to get the instance of the singleton class
    public static EagerSingletonWithStaticBlock getInstance() {
        return instance;
    }

    // Other methods of the singleton class
    public void someMethod() {
        System.out.println("Executing some method in EagerSingletonWithStaticBlock class.");
    }
    
    
    // Example usage in a main method
    public static void main(String[] args) {
    	// Using Eager Initialization with Static Block
        EagerSingletonWithStaticBlock eagerInstance1 = EagerSingletonWithStaticBlock.getInstance();
        EagerSingletonWithStaticBlock eagerInstance2 = EagerSingletonWithStaticBlock.getInstance();

        // Both instances should refer to the same object
        System.out.println("Eager Initialization with Static Block: " + (eagerInstance1 == eagerInstance2)); // true
    
        // Using the EagerSingletonWithStaticBlock instance
        eagerInstance1.someMethod();
        eagerInstance2.someMethod();
	}
}
