package annotation.advancedlevel.rolebasedcontrol;

public class AdminOperations {

    // Apply @RoleAllowed annotation to restrict access to ADMIN role
    @RoleAllowed("ADMIN")
    public void deleteUser(User user) {
        System.out.println("User " + user.getUsername() + " has been deleted.");
    }

    // Apply @RoleAllowed annotation to restrict access to ADMIN role
    @RoleAllowed("ADMIN")
    public void updateUser(User user) {
        System.out.println("User " + user.getUsername() + " has been updated.");
    }

    // Method that can be accessed by anyone
    public void viewUser(User user) {
        System.out.println("Viewing user: " + user.getUsername());
    }
}
