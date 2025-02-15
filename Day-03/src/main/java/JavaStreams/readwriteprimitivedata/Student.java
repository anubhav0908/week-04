package JavaStreams.readwriteprimitivedata;

public class Student {
    private final int rollNumber;
    private final String name;
    private final double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
}
