package basictesting;

import junittesting.basictesting.calculatortesting.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));  // 2 + 3 = 5
        assertEquals(0, calculator.add(2, -2)); // 2 + (-2) = 0
        assertEquals(-5, calculator.add(-2, -3)); // -2 + (-3) = -5
    }

    // Test for subtraction
    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2));  // 3 - 2 = 1
        assertEquals(4, calculator.subtract(2, -2)); // 2 - (-2) = 4
        assertEquals(1, calculator.subtract(-2, -3)); // -2 - (-3) = 1
    }

    // Test for multiplication
    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3));   // 2 * 3 = 6
        assertEquals(-6, calculator.multiply(2, -3));  // 2 * (-3) = -6
        assertEquals(0, calculator.multiply(0, 5));    // 0 * 5 = 0
        assertEquals(6, calculator.multiply(-2, -3));  // -2 * -3 = 6
    }

    // Test for division
    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2.0, calculator.divide(6, 3));   // 6 / 3 = 2.0
        assertEquals(-2.0, calculator.divide(6, -3));  // 6 / -3 = -2.0
        assertEquals(0.0, calculator.divide(0, 5));    // 0 / 5 = 0.0
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0)); // Division by zero should throw exception
    }
}

