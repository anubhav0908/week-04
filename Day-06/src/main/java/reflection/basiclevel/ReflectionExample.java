package reflection.basiclevel;

import java.lang.reflect.Field;

class Person {
    // Private field
    private int age;

    // Constructor
    public Person(int age) {
        this.age = age;
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Create an instance of the Person class
            Person person = new Person(25);

            // Access the Person class using reflection
            Class<?> personClass = person.getClass();

            // Access the private field 'age' using reflection
            Field ageField = personClass.getDeclaredField("age");

            // Make the private field accessible
            ageField.setAccessible(true);

            // Get the current value of 'age'
            int ageValue = (int) ageField.get(person);
            System.out.println("Current age: " + ageValue);

            // Modify the value of 'age' using reflection
            ageField.set(person, 30);
            System.out.println("Updated age: " + ageField.get(person));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

