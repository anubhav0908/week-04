package annotation.exercise2;

public class Main {
    public static void main(String[] args) {
        // Instantiate the LegacyAPI class
        LegacyAPI api = new LegacyAPI();

        // Call the deprecated method
        api.oldFeature(); // This will show a warning since it is deprecated

        // Call the new method
        api.newFeature(); // This is the recommended method to use
    }
}

