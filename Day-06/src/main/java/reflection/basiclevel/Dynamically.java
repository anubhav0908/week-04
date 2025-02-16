package reflection.basiclevel;

import java.lang.reflect.Constructor;

public class Dynamically {
    public static void main(String[] args) {
        try {
            // The fully qualified class name of the Student class
            String className = "Dynamically$Student"; // Inner class name

            // Load the outer class 'Dynamically' first
            Class<?> outerClass = Class.forName("Dynamically");

            // Create an instance of the outer class
            Object outerClassInstance = outerClass.getDeclaredConstructor().newInstance();

            // Now, load the inner class 'Student' as a non-static inner class
            Class<?> studentClass = Class.forName(className);

            // Get the constructor of the Student class that takes (String, int)
            Constructor<?> constructor = studentClass.getDeclaredConstructor(outerClass, String.class, int.class);

            // Dynamically create an instance of Student using reflection (with outer class instance)
            Object studentObject = constructor.newInstance(outerClassInstance, "John Doe", 20);

            // Cast the object to Student type and call the display method
            Student student = (Student) studentObject;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Non-static inner class
    public class Student {
        private String name;
        private int age;

        // Constructor
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to display student information
        public void display() {
            System.out.println("Student Name: " + name);
            System.out.println("Student Age: " + age);
        }
    }
}
