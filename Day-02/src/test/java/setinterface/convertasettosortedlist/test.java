package setinterface.convertasettosortedlist;

import collections.setinterface.convertasettosortedlist.ConvertSetToSortedList;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testConvertToList() {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(8);
        set1.add(6);

        List<Integer> expectedList = Arrays.asList(1, 2, 6, 8);  // Expected sorted order
        List<Integer> actualList = ConvertSetToSortedList.convertToList(set1);

        assertEquals(expectedList, actualList);
    }
}
