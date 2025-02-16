package reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Display the available methods for the user
            System.out.println("Available operations: add, subtract, multiply");
            System.out.print("Enter the operation you want to perform: ");
            String operation = scanner.nextLine();

            // Get the Method object for the chosen operation
            Method method = MathOperations.class.getMethod(operation, int.class, int.class);

            // Ask the user for input numbers
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Dynamically invoke the chosen method and get the result
            int result = (int) method.invoke(mathOperations, num1, num2);

            // Display the result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            // Handle errors such as method not found, invalid input, etc.
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
