package collections.queueinterface.hospitaltriagesystem;

public class Patient {
    private String name;
    private int severity; // Higher value means more severe
      //constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
   //getter methods
    public String getName() {
        return name;
    }
    public int getSeverity() {
        return severity;
    }
}
