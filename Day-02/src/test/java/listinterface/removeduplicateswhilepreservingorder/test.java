package listinterface.removeduplicateswhilepreservingorder;

import collections.listinterface.removeduplicateswhilepreservingorder.RemoveDuplicatesWhilePreservingOrder;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testRemoveDuplicates() {
        List<Integer> input = Arrays.asList(3, 2, 3, 6);
        List<Integer> expected = Arrays.asList(3, 2, 6);

        assertEquals(expected, RemoveDuplicatesWhilePreservingOrder.removeDuplicates(input));
    }
}
