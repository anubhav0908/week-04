package mapinterface.mergetwomaps;

import collections.mapinterface.mergetwomaps.MergeTwoMaps;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class test {

    @Test
    public void testMergeMaps() {
        // Create first map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Create second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Expected merged map
        Map<String, Integer> expectedMergedMap = new HashMap<>();
        expectedMergedMap.put("A", 1);
        expectedMergedMap.put("B", 5); // 2 + 3
        expectedMergedMap.put("C", 4);

        // Call mergeMaps and validate result
        assertEquals(expectedMergedMap, MergeTwoMaps.mergeMaps(map1, map2));
    }
}
