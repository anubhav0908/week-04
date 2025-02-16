package annotation.intermediatelevel.loggingexecutiontime;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Create an instance of the PerformanceTest class
            PerformanceTest performanceTest = new PerformanceTest();

            // Get the PerformanceTest class
            Class<?> performanceTestClass = PerformanceTest.class;

            // Get all methods in the PerformanceTest class
            Method[] methods = performanceTestClass.getDeclaredMethods();

            // Loop through each method and check for the @LogExecutionTime annotation
            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    // Start measuring execution time
                    long startTime = System.nanoTime();

                    // Invoke the method using reflection
                    method.invoke(performanceTest);

                    // End measuring execution time
                    long endTime = System.nanoTime();

                    // Calculate the execution time in nanoseconds
                    long executionTime = endTime - startTime;

                    // Print the execution time of the method
                    System.out.println("Execution time of method " + method.getName() + ": " + executionTime + " nanoseconds");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
