package basictesting;

import junittesting.basictesting.parameterized.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    private final NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})  // Even numbers to test
    void testIsEven_WithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), "The number " + number + " should be even.");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})  // Odd numbers to test
    void testIsEven_WithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), "The number " + number + " should not be even.");
    }
}

