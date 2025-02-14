package listinterface.reversealist;

import collections.listinterface.reversealist.ReverseArrayList;
import collections.listinterface.reversealist.ReverseLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testReverseArrayList() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 8, 1));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 8, 4, 3));

        ReverseArrayList.reverseArrayList(input);
        assertEquals(expected, input);
    }

    @Test
    public void testReverseLinkedList() {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(1, 3, 5, 6, 9));
        LinkedList<Integer> expected = new LinkedList<>(Arrays.asList(9, 6, 5, 3, 1));

        ReverseLinkedList.reverseLinkedList(input);
        assertEquals(expected, input);
    }
}
