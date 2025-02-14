package collections.queueinterface.hospitaltriagesystem;
import java.util.*;

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new SeverityComparator());

        // Adding patients
        triageQueue.add(new Patient("Shristy", 3));
        triageQueue.add(new Patient("Arjun", 5));
        triageQueue.add(new Patient("Nancy", 2));

        // Treat patients in order of severity
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll().getName());
        }
    }
}
