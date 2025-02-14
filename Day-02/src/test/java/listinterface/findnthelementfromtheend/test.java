package listinterface.findnthelementfromtheend;

import collections.listinterface.findnthelementfromtheend.FindnthElement;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class test {
    @Test
    public void testFindnthElement() {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');

        assertEquals(Character.valueOf('D'), FindnthElement.findnthElement(list, 2));
    }
}
