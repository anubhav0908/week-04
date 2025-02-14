package collections.queueinterface.hospitaltriagesystem;

import java.util.Comparator;

public class SeverityComparator implements Comparator<Patient> {
    //override the compare method
    @Override
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.getSeverity(), p1.getSeverity()); // Descending order
    }
}
