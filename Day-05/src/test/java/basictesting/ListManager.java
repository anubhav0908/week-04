package basictesting;

import junittesting.basictesting.listoperation.ListManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {

    private ListManager listManager;
    private List<Integer> list;

    // Setup before each test
    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));
        assertTrue(list.contains(5));

          assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        listManager.addElement(list, 15);

        assertTrue(listManager.removeElement(list, 10));
        assertFalse(list.contains(10));
        assertEquals(2, listManager.getSize(list));

    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(list));

        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));

    }
}

