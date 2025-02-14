package collections.mapinterface.groupobjectsbyproperty;
import java.util.*;
import java.util.stream.Collectors;
public class GroupObjectsByProperty {
    public static void main(String[] args) {
        //create list of employees
        List<Employee> employees = Arrays.asList(
                //add employees
                new Employee("Arjun", "HR"),
                new Employee("Nancy", "IT"),
                new Employee("Shristy", "HR"),
                new Employee("David", "Finance")
        );

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        groupedByDepartment.forEach((dept, empList) ->
                System.out.println(dept + ": " + empList)
        );
    }
}
