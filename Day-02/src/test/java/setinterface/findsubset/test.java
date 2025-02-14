package setinterface.findsubset;

import collections.setinterface.findsubset.FindSubset;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class test {
    @Test
    public void testFindSubset() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(5);
        set2.add(7);

        assertTrue(FindSubset.findSubset(set1, set2));

        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(5);

        assertFalse(FindSubset.findSubset(set3, set2));
    }
}
