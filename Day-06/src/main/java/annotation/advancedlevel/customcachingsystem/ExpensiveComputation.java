package annotation.advancedlevel.customcachingsystem;

// ExpensiveComputation class now implements the Computation interface
public class ExpensiveComputation implements Computation {

    @Override
    @CacheResult  // Mark the method for caching
    public int compute(int a, int b) {
        try {
            Thread.sleep(3000);  // Simulate delay (expensive computation)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;  // Return the computed result
    }
}

