package setinterface.symmetricdifference;

import collections.setinterface.symmetricdifference.SymmetricDifference;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testFindSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(6);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(6);
        set2.add(7);

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(7);

        assertEquals(expected, SymmetricDifference.findSymmetricDifference(set1, set2));

        Set<Integer> set3 = new HashSet<>();
        set3.add(10);
        set3.add(20);

        Set<Integer> set4 = new HashSet<>();
        set4.add(10);
        set4.add(30);

        Set<Integer> expected2 = new HashSet<>();
        expected2.add(20);
        expected2.add(30);

        assertEquals(expected2, SymmetricDifference.findSymmetricDifference(set3, set4));
    }
}
