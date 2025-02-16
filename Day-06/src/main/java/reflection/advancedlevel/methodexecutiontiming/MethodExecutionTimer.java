package reflection.advancedlevel.methodexecutiontiming;

import java.lang.reflect.Method;

public class MethodExecutionTimer {

    public static void measureExecutionTime(Object obj, String methodName, Object... args) throws Exception {
        // Get the Class object of the class that contains the method
        Class<?> clazz = obj.getClass();

        // Find the method with the given name and parameter types
        Method method = findMethod(clazz, methodName, args);

        // Record start time
        long startTime = System.currentTimeMillis();

        // Invoke the method dynamically using reflection
        Object result = method.invoke(obj, args);

        // Record end time
        long endTime = System.currentTimeMillis();

        // Calculate the execution time
        long executionTime = endTime - startTime;

        // Print the result and the time taken
        System.out.println("Method " + methodName + " executed in " + executionTime + " ms.");
        System.out.println("Result: " + result);
    }

    // Helper method to find the method with the matching name and parameter types
    private static Method findMethod(Class<?> clazz, String methodName, Object[] args) throws NoSuchMethodException {
        Class<?>[] argTypes = new Class[args.length];

        // Convert primitive types in args to their wrapper classes
        for (int i = 0; i < args.length; i++) {
            argTypes[i] = args[i].getClass();

            // Handle primitive types (int, double, etc.) correctly
            if (args[i] instanceof Integer) {
                argTypes[i] = int.class;  // Convert Integer to int.class for reflection
            }
            // Add handling for other primitive types if needed (e.g., Double, Long)
        }

        return clazz.getMethod(methodName, argTypes); // Find the method with the exact signature
    }
}
