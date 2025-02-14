package mapinterface.findthekeywithhighestvalue;

import collections.mapinterface.findthekeywithhighestvalue.FindKeyWithHighestValue;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class test {

    @Test
    public void testFindHighestKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        map.put("D", 40);

        assertEquals("D", FindKeyWithHighestValue.findHighestKey(map));
    }

    @Test
    public void testFindHighestKeyWithSingleEntry() {
        Map<String, Integer> map = new HashMap<>();
        map.put("X", 100);

        assertEquals("X", FindKeyWithHighestValue.findHighestKey(map));
    }

    @Test
    public void testFindHighestKeyWithEmptyMap() {
        Map<String, Integer> map = new HashMap<>();

        assertNull(FindKeyWithHighestValue.findHighestKey(map));
    }
}
