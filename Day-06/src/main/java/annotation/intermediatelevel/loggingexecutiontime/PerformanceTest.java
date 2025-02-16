package annotation.intermediatelevel.loggingexecutiontime;

public class PerformanceTest {

    // Apply @LogExecutionTime annotation to measure execution time of this method
    @LogExecutionTime
    public void methodOne() {
        // Simulate some work with a sleep
        try {
            Thread.sleep(200); // Simulating work that takes 200 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Apply @LogExecutionTime annotation to measure execution time of this method
    @LogExecutionTime
    public void methodTwo() {
        // Simulate some work with a sleep
        try {
            Thread.sleep(500); // Simulating work that takes 500 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Apply @LogExecutionTime annotation to measure execution time of this method
    @LogExecutionTime
    public void methodThree() {
        // Simulate some work with a sleep
        try {
            Thread.sleep(300); // Simulating work that takes 300 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
