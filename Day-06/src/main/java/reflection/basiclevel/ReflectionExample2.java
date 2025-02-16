package reflection.basiclevel;

import java.lang.reflect.Method;

class Calculator {
    // Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionExample2 {
    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Access the Calculator class using reflection
            Class<?> calculatorClass = calculator.getClass();

            // Access the private method 'multiply' using reflection
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method with parameters (5, 6)
            int result = (int) multiplyMethod.invoke(calculator, 5, 6);

            // Display the result
            System.out.println("Result of multiply(5, 6): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

