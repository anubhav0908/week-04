package basictesting;


import junittesting.basictesting.exceptionhandling.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculators {

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testValidDivision() {
        Calculator calculator = new Calculator();

        assertEquals(5.0, calculator.divide(10, 2));
        assertEquals(-2.0, calculator.divide(10, -5));
    }
}
