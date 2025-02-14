package mapinterface.invertamap;

import collections.mapinterface.invertamap.InvertAMap;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class test {

    @Test
    public void testInvertMap() {
        // Create an original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Expected inverted map
        Map<Integer, List<String>> expectedInvertedMap = new HashMap<>();
        expectedInvertedMap.put(1, Arrays.asList("A", "C"));
        expectedInvertedMap.put(2, Collections.singletonList("B"));

        // Call invertMap
        Map<Integer, List<String>> actualInvertedMap = InvertAMap.invertMap(originalMap);

        // Validate the size of keys
        assertEquals(expectedInvertedMap.size(), actualInvertedMap.size());

        // Validate the values (lists of keys)
        assertTrue(actualInvertedMap.get(1).containsAll(Arrays.asList("A", "C")));
        assertTrue(actualInvertedMap.get(2).contains("B"));
    }

    @Test
    public void testInvertMapWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        Map<Integer, List<String>> invertedMap = InvertAMap.invertMap(emptyMap);

        assertTrue(invertedMap.isEmpty());
    }
}
