package junittesting.basictesting.exceptionhandling;

public class Calculator {

    // Method to divide two numbers, throws ArithmeticException if b is zero
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}

