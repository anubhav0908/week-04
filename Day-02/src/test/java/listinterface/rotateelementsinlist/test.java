package listinterface.rotateelementsinlist;

import collections.listinterface.rotateelementsinlist.RotateElementsInAList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testRotateElementsInList() {
        RotateElementsInAList<Integer> rotateList = new RotateElementsInAList<>();

        // Convert to an ArrayList so modifications are allowed
        List<Integer> input = new ArrayList<>(Arrays.asList(6, 2, 5, 8));
        List<Integer> expected = Arrays.asList(8, 6, 2, 5);

        // Perform rotation
        rotateList.rotateElementsInList(input, 3);

        // Assert after modification
        assertEquals(expected, input);
    }
}
