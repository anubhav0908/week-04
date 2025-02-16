package annotation.intermediatelevel.fieldvalidation;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a user with a valid username (within the 10-character limit)
            User user1 = new User("validUser");
            user1.displayUserInfo();  // Should print the username

            // Try to create a user with an invalid username (more than 10 characters)
            User user2 = new User("thisUsernameIsTooLong");  // Should throw IllegalArgumentException
            user2.displayUserInfo();  // This line won't be executed due to exception

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());  // Catch and display the exception message
        }
    }
}
