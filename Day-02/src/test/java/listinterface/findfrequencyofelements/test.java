package listinterface.findfrequencyofelements;

import collections.listinterface.findfrequencyofelements.FinfFrequencyOfElements;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testFindFrequencyWithDuplicates() {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 2);
        expected.put("banana", 1);
        expected.put("orange", 1);

        assertEquals(expected, FinfFrequencyOfElements.findFrequency(input));
    }
}
