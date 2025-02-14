package queueinterface.implementstackusingqueue;

import collections.queueinterface.implementstackusingqueue.ImplementStackUsingQueue;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class test {

    @Test
    public void testStackOperations() {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        stack.pop();
    }

    @Test(expected = NoSuchElementException.class)
    public void testTopOnEmptyStack() {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        stack.top();
    }
}
