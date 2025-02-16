package reflection.advancedlevel.methodexecutiontiming;

public class Main {
    public static void main(String[] args) {
        try {
            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Measure the execution time of the 'add' method
            MethodExecutionTimer.measureExecutionTime(mathOperations, "add", 5, 10);

            // Measure the execution time of the 'multiply' method
            MethodExecutionTimer.measureExecutionTime(mathOperations, "multiply", 3, 4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
