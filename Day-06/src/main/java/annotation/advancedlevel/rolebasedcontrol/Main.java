package annotation.advancedlevel.rolebasedcontrol;

public class Main {
    public static void main(String[] args) {
        // Simulating different users
        User adminUser = new User("AdminUser", "ADMIN");
        User regularUser = new User("RegularUser", "USER");

        // Create an instance of AdminOperations
        AdminOperations adminOperations = new AdminOperations();

        // Test with an ADMIN user
        System.out.println("Testing with Admin User:");
        AccessControl.checkAccess(adminUser, adminOperations, "deleteUser");  // Should succeed
        AccessControl.checkAccess(adminUser, adminOperations, "updateUser");  // Should succeed
        AccessControl.checkAccess(adminUser, adminOperations, "viewUser");  // Should succeed

        // Test with a regular USER
        System.out.println("\nTesting with Regular User:");
        AccessControl.checkAccess(regularUser, adminOperations, "deleteUser");  // Should be denied
        AccessControl.checkAccess(regularUser, adminOperations, "updateUser");  // Should be denied
        AccessControl.checkAccess(regularUser, adminOperations, "viewUser");  // Should succeed
    }
}

