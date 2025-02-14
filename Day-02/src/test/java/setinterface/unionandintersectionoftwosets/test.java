package setinterface.unionandintersectionoftwosets;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testUnionAndIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(6);

        Set<Integer> set2 = new HashSet<>();
        set2.add(5);
        set2.add(8);
        set2.add(2);

        // Expected union set
        Set<Integer> expectedUnion = new HashSet<>();
        expectedUnion.add(1);
        expectedUnion.add(2);
        expectedUnion.add(6);
        expectedUnion.add(5);
        expectedUnion.add(8);

        // Expected intersection set
        Set<Integer> expectedIntersection = new HashSet<>();
        expectedIntersection.add(2);

        // Compute actual union and intersection
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        assertEquals(expectedUnion, unionSet);
        assertEquals(expectedIntersection, intersectionSet);
    }
}
