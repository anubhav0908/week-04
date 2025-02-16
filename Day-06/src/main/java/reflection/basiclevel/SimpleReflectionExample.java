package reflection.basiclevel;

import java.lang.reflect.*;

import java.util.Scanner;

public class SimpleReflectionExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the class name from user input
        System.out.print("Enter the class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            // Load the class using Class.forName
            Class<?> clazz = Class.forName(className);

            // Print all methods of the class
            System.out.println("\nMethods:");
            for (Method method : clazz.getMethods()) {
                System.out.println(method.getName());
            }

            // Print all fields of the class
            System.out.println("\nFields:");
            for (Field field : clazz.getFields()) {
                System.out.println(field.getName());
            }

            // Print all constructors of the class
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getConstructors()) {
                System.out.println(constructor.getName());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " not found.");
        }
    }
}
