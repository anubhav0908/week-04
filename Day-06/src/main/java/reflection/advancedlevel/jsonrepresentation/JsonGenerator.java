package reflection.advancedlevel.jsonrepresentation;

import java.lang.reflect.Field;

public class JsonGenerator {

    // Method to generate a JSON-like string from an object using reflection
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        // Get the class of the object
        Class<?> objClass = obj.getClass();

        // Get all fields of the class (including private and protected fields)
        Field[] fields = objClass.getDeclaredFields();

        try {
            // Iterate through each field
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true); // Make the field accessible (in case it's private)

                // Get the field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                // Append the field name and value to the JSON string
                json.append("\"").append(fieldName).append("\": ");

                // Check if the value is a String, and surround it with quotes
                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    // Otherwise, just append the value as it is
                    json.append(fieldValue);
                }

                // Add a comma after each field except the last one
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        json.append("}");
        return json.toString();
    }
}

