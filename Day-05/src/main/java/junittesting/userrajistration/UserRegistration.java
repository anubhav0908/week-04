package junittesting.userrajistration;

public class UserRegistration {

    public void registerUser(String username, String email, String password) {
        // Validate username
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty or null.");
        }

        // Validate email format
        if (email == null || !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Validate password (minimum 8 characters)
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }

        // If all inputs are valid, proceed with registration (in real scenarios, we'd save to database)
        System.out.println("User registered successfully.");
    }
}
