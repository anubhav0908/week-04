package reflection.intermediatelevel;

import java.lang.reflect.Field;

public class ReflectionExample2 {
    public static void main(String[] args) {
        try {
            // Get the Configuration class object
            Class<?> configClass = Configuration.class;

            // Get the private static field 'API_KEY'
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible (bypassing the private modifier)
            apiKeyField.setAccessible(true);

            // Modify the value of the static field 'API_KEY'
            apiKeyField.set(null, "new_api_key_value");

            // Print the modified value using the static method
            Configuration.printAPIKey();  // This will print the modified API_KEY

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

