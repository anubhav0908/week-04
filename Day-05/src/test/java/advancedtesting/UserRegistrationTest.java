package advancedtesting;

import junittesting.userrajistration.UserRegistration;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    // Test valid user registration
    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> {
            userRegistration.registerUser("validUser", "valid.email@example.com", "StrongPassword123");
        }, "Valid inputs should not throw exceptions.");
    }

    // Test invalid username (empty username)
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "valid.email@example.com", "StrongPassword123");
        }, "Username cannot be empty or null.");
    }

    // Test invalid username (null username)
    @Test
    void testNullUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser(null, "valid.email@example.com", "StrongPassword123");
        }, "Username cannot be empty or null.");
    }

    // Test invalid email (invalid format)
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "invalid-email", "StrongPassword123");
        }, "Invalid email format.");
    }

    // Test invalid password (too short)
    @Test
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "valid.email@example.com", "short");
        }, "Password must be at least 8 characters long.");
    }

    // Test invalid password (null password)
    @Test
    void testNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "valid.email@example.com", null);
        }, "Password must be at least 8 characters long.");
    }
}

