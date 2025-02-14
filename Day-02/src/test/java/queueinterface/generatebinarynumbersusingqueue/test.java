package queueinterface.generatebinarynumbersusingqueue;

import collections.queueinterface.generatebinarynumbersusingqueue.GenerateBinaryNumbers;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void testGenerateBinaryNumbers() {
        assertEquals(Arrays.asList("1", "10", "11", "100"), GenerateBinaryNumbers.generateBinaryNumbers(4));
        assertEquals(Arrays.asList("1", "10", "11", "100", "101", "110"), GenerateBinaryNumbers.generateBinaryNumbers(6));
        assertEquals(Arrays.asList("1"), GenerateBinaryNumbers.generateBinaryNumbers(1));
    }
}
