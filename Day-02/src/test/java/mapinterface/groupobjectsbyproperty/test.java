package mapinterface.groupobjectsbyproperty;

import collections.mapinterface.groupobjectsbyproperty.Employee;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class test {

    @Test
    public void testGroupByDepartment() {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Arjun", "HR"),
                new Employee("Nancy", "IT"),
                new Employee("Shristy", "HR"),
                new Employee("David", "Finance")
        );

        // Group by department
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Expected results
        assertEquals(2, groupedByDepartment.get("HR").size());
        assertEquals(1, groupedByDepartment.get("IT").size());
        assertEquals(1, groupedByDepartment.get("Finance").size());

        // Checking employee names
        List<String> hrEmployees = groupedByDepartment.get("HR").stream()
                .map(Employee::getName)
                .toList();
        assertTrue(hrEmployees.containsAll(Arrays.asList("Arjun", "Shristy")));

        assertEquals("Nancy", groupedByDepartment.get("IT").get(0).getName());
        assertEquals("David", groupedByDepartment.get("Finance").get(0).getName());
    }

    @Test
    public void testGroupByDepartmentWithEmptyList() {
        List<Employee> employees = new ArrayList<>();

        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        assertTrue(groupedByDepartment.isEmpty());
    }
}
