package queueinterface.reversequeue;

import collections.queueinterface.reversequeue.ReverseAQueue;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class test {
    @Test
    public void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30, 40));
        Queue<Integer> expectedReversedQueue = new LinkedList<>(Arrays.asList(40, 30, 20, 10));

        ReverseAQueue.reverseQueue(queue);

        assertEquals(expectedReversedQueue, queue);
    }
}
