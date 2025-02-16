package annotation.advancedlevel.customserialization;

import java.lang.reflect.Field;

public class JsonSerializer {

    // Method to convert an object to a JSON string based on @JsonField annotations
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        // Get all fields of the class
        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            // Iterate through each field
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);  // Make the field accessible even if it's private

                // Check if the field has the @JsonField annotation
                if (field.isAnnotationPresent(JsonField.class)) {
                    // Get the custom name for the JSON field from the annotation
                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    String jsonKey = jsonField.name();

                    // Get the value of the field
                    Object value = field.get(obj);

                    // Append the key-value pair to the JSON string
                    json.append("\"").append(jsonKey).append("\": \"").append(value).append("\"");

                    // Add a comma if this is not the last field
                    if (i < fields.length - 1) {
                        json.append(", ");
                    }
                }
            }

            // Close the JSON object
            json.append("}");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
}

