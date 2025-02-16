package reflection.advancedlevel.customobjectmapper;

public class Person {
    private String name;
    private int age;

    // Constructor
    public Person() {}

    // Getters and Setters (Optional for reflection, if needed)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display person info
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

