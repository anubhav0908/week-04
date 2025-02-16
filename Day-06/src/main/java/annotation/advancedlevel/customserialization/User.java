package annotation.advancedlevel.customserialization;

public class User {
    @JsonField(name = "user_name")  // Custom JSON key for 'name'
    private String name;

    @JsonField(name = "user_age")   // Custom JSON key for 'age'
    private int age;

    @JsonField(name = "user_email") // Custom JSON key for 'email'
    private String email;

    // Constructor
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters for fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
