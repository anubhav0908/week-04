import exceptions.customexception.InvalidAgeException;
import exceptions.exceptionpropagation.InterestCalculator;
import exceptions.exceptionpropagationmethods.ExceptionPropagationDemo;
import org.junit.Test;
import static exceptions.multiplecatchblocks.ArrayOperations.accessArray;
import static org.junit.Assert.*;

public class test {

    @Test
    public void testValidIndex() {
        Integer[] array = {10, 20, 30, 40, 50};
        accessArray(array, 2);
    }

    @Test
    public void testInvalidIndex() {
        Integer[] array = {10, 20, 30, 40, 50};
        accessArray(array, 10);
    }

    @Test
    public void testNullArray() {
        accessArray(null, 2);
    }
    @Test
   public void testCalculateInterestValid() {
        assertEquals(100.0, InterestCalculator.calculateInterest(1000, 5, 2));
    }

    @Test
   public void testCalculateInterestNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InterestCalculator.calculateInterest(-1000, 5, 2)
        );
        assertEquals("Amount and rate must be positive", exception.getMessage());
    }

    @Test
  public   void testCalculateInterestNegativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                InterestCalculator.calculateInterest(1000, -5, 2)
        );
        assertEquals("Amount and rate must be positive", exception.getMessage());
    }
    @Test
    public void testExceptionPropagation() {
        Exception exception = assertThrows(ArithmeticException.class, ExceptionPropagationDemo::method2);
        assertEquals("Division by zero", exception.getMessage());
    }


}
