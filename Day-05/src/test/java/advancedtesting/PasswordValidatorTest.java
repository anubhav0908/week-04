package advancedtesting;

import junittesting.advancedtesting.passworsstrength.PasswordValidator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    // Test for valid password
    @Test
    void testValidPassword() {
        String validPassword = "Password1";
        assertTrue(passwordValidator.isValid(validPassword), "Password should be valid.");
    }

    // Test for password with less than 8 characters
    @Test
    void testShortPassword() {
        String shortPassword = "Pass1";
        assertFalse(passwordValidator.isValid(shortPassword), "Password should be invalid (less than 8 characters).");
    }

    // Test for password without an uppercase letter
    @Test
    void testNoUpperCase() {
        String noUpperCasePassword = "password1";
        assertFalse(passwordValidator.isValid(noUpperCasePassword), "Password should be invalid (no uppercase letter).");
    }

    // Test for password without a digit
    @Test
    void testNoDigit() {
        String noDigitPassword = "Password";
        assertFalse(passwordValidator.isValid(noDigitPassword), "Password should be invalid (no digit).");
    }

    // Test for password that meets all criteria
    @Test
    void testValidPasswordWithAllConditions() {
        String validPassword = "Valid123";
        assertTrue(passwordValidator.isValid(validPassword), "Password should be valid.");
    }
}

