package queueinterface.hospitaltriagesystem;

import collections.queueinterface.hospitaltriagesystem.Patient;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.PriorityQueue;

public class test {
    @Test
    public void testTriageQueue() {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new SeverityComparator());

        triageQueue.add(new Patient("Shristy", 3));
        triageQueue.add(new Patient("Arjun", 5));
        triageQueue.add(new Patient("Nancy", 2));

        // Expected order: Arjun (5), Shristy (3), Nancy (2)
        assertEquals("Arjun", triageQueue.poll().getName());
        assertEquals("Shristy", triageQueue.poll().getName());
        assertEquals("Nancy", triageQueue.poll().getName());
    }
}
