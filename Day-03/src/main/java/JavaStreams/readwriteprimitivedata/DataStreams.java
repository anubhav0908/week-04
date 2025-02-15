package JavaStreams.readwriteprimitivedata;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataStreams {
    public static void writeData(String filepath, List<Student> students) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filepath))) {
            for (Student student : students) {
                dataOutputStream.writeInt(student.getRollNumber());
                dataOutputStream.writeUTF(student.getName());
                dataOutputStream.writeDouble(student.getGpa());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readData(String filepath) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filepath))) {
            System.out.println("Displaying data - ");
            while (dataInputStream.available() > 0) {
                int rollNumber = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                double gpa = dataInputStream.readDouble();

                System.out.println(rollNumber + " " + name + " " + gpa);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filepath = "file.txt";

        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student(1, "Aditya", 8.3),
                new Student(2, "Bhavesh", 8.9),
                new Student(3, "Harshit", 7.3)
        );

        // Writing data to the file
        DataStreams.writeData(filepath, students);
        System.out.println("Data successfully written to file.");

        // Reading and displaying data
        DataStreams.readData(filepath);
    }
}
