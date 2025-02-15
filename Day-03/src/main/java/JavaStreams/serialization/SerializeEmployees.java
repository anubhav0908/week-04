package JavaStreams.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeEmployees {
    public static void serializeEmployees(String filepath){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Brandon", "IT", 60000));
        employees.add(new Employee(102, "Bob", "Finance", 45000));
        employees.add(new Employee(103, "Ash", "HR", 50000));

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath));
            objectOutputStream.writeObject(employees);
            System.out.println("Employees serialized successfully !!");

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void deserializeEmployees(String filepath){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath));

            List<Employee> employees = (List<Employee>) objectInputStream.readObject();

            for(Employee employee : employees){
                System.out.println(employee);
            }

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error : " + e.getMessage());
        }

        System.out.println("Deserialized successfully !!");
    }

    public static void main(String[] args) {
        String filepath = "serializeEmployee.txt";

        serializeEmployees(filepath);

        deserializeEmployees(filepath);
    }
}
