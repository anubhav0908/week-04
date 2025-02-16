package annotation.advancedlevel.rolebasedcontrol;

public class User {
    private String username;
    private String role;

    // Constructor to initialize username and role
    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters for username and role
    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
