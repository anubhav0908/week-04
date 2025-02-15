package junittesting.advancedtesting.passworsstrength;

public class PasswordValidator {

    // Method to validate the password
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;  // Password must be at least 8 characters long
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        // Iterate through the characters in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        // Return true if both conditions are satisfied
        return hasUpperCase && hasDigit;
    }
}
