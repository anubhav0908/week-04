package reflection.advancedlevel.customobjectmapper;

import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create a new instance of the target class
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Iterate over the map to set values to the object's fields
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            // Get the field by name
            try {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true); // Make sure we can access private fields

                // Set the field value
                field.set(obj, entry.getValue());
            } catch (NoSuchFieldException e) {
                // Handle case where the field does not exist in the class
                System.out.println("No such field: " + entry.getKey());
            }
        }

        // Return the populated object
        return obj;
    }
}

