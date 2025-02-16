package annotation.exercise3;

import java.util.ArrayList;

public class SuppressUncheckedWarningsExample {

    @SuppressWarnings("unchecked") // Suppress unchecked warnings in this method
    public static void main(String[] args) {
        // Create an ArrayList without generics (raw type)
        ArrayList list = new ArrayList();

        // Add elements of different types (this causes unchecked warnings)
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Accessing the list and casting it
        String str = (String) list.get(0);  // Unchecked cast
        int num = (Integer) list.get(1);    // Unchecked cast
        double d = (Double) list.get(2);    // Unchecked cast

        // Output the values
        System.out.println("String: " + str);
        System.out.println("Integer: " + num);
        System.out.println("Double: " + d);
    }
}

