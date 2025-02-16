package reflection.advancedlevel.jsonrepresentation;

public class ReflectionMain {
    public static void main(String[] args) {
        // Create an instance of the Person class
        Person person = new Person("Om Prakash", 23, 5.3);

        // Generate JSON-like string using the JsonGenerator
        String jsonString = JsonGenerator.toJson(person);

        // Print the resulting JSON-like string
        System.out.println(jsonString);
    }
}

