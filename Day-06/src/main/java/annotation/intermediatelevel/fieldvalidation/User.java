package annotation.intermediatelevel.fieldvalidation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class User {

    // Apply the @MaxLength annotation to the username field
    @MaxLength(value = 10)  // Maximum length allowed is 10 characters
    private String username;

    // Constructor that validates the length of the username
    public User(String username) {
        // Get the field of the username
        try {
            Field field = this.getClass().getDeclaredField("username");

            // Check if the field has the @MaxLength annotation
            if (field.isAnnotationPresent(MaxLength.class)) {
                // Get the maximum length value from the annotation
                MaxLength maxLengthAnnotation = field.getAnnotation(MaxLength.class);
                int maxLength = maxLengthAnnotation.value();

                // Validate the length of the username
                if (username.length() > maxLength) {
                    throw new IllegalArgumentException("Username exceeds the maximum length of " + maxLength);
                }
            }

            // If validation passes, assign the value to the username field
            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    // Getter for the username
    public String getUsername() {
        return username;
    }

    // Method to display user information
    public void displayUserInfo() {
        System.out.println("Username: " + username);
    }
}
