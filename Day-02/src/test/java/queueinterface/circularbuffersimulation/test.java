package queueinterface.circularbuffersimulation;

import collections.queueinterface.circularbuffersimulation.CircularBufferSimulation;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class test {
    @Test
    public void testCircularBuffer() {
        CircularBufferSimulation cb = new CircularBufferSimulation(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        assertArrayEquals(new int[]{1, 2, 3}, cb.getBuffer());

        cb.insert(4);
        assertArrayEquals(new int[]{2, 3, 4}, cb.getBuffer());

        cb.insert(5);
        assertArrayEquals(new int[]{3, 4, 5}, cb.getBuffer());

        cb.insert(6);
        cb.insert(7);
        assertArrayEquals(new int[]{5, 6, 7}, cb.getBuffer());
    }
}
