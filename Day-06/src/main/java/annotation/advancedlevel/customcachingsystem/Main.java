package annotation.advancedlevel.customcachingsystem;

public class Main {
    public static void main(String[] args) {
        // Create an instance of ExpensiveComputation
        Computation expensiveComputation = new ExpensiveComputation();

        // Create a proxy for the ExpensiveComputation class (interface type)
        Computation proxy = (Computation) CachingProxy.createProxy(expensiveComputation);

        // Test the method with caching
        System.out.println("First call: " + proxy.compute(5, 10));  // Will take time and compute the result
        System.out.println("Second call: " + proxy.compute(5, 10)); // Will return cached result
    }
}

