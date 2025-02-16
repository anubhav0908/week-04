package reflection.advancedlevel.customobjectmapper;

import java.util.HashMap;
import java.util.Map;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Prepare the map with field names and values
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", "Om Prakash");
            properties.put("age", 23);

            // Use the ObjectMapper to convert the map to a Person object
            Person person = ObjectMapper.toObject(Person.class, properties);

            // Display the populated object
            person.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

