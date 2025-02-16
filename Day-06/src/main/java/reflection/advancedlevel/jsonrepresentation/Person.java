package reflection.advancedlevel.jsonrepresentation;

public class Person {
    private String name;
    private int age;
    private double height;

    // Constructor
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    // Getters (optional for reflection)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}

