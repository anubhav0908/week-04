package reflection.advancedlevel.methodexecutiontiming;

public class MathOperations {
    public int add(int a, int b) {
        try {
            Thread.sleep(500); // Simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }

    public int multiply(int a, int b) {
        try {
            Thread.sleep(300); // Simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * b;
    }
}

