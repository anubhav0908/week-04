package collections.mapinterface.groupobjectsbyproperty;

public class Employee {
    private String name;
    private String department;
     //constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
     //getter
    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
   //override the to string method
    @Override
    public String toString() {
        return name;
    }
}
