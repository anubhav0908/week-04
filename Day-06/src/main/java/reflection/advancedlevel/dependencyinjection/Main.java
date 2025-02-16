package reflection.advancedlevel.dependencyinjection;

public class Main {
    public static void main(String[] args) {
        try {
            DIContainer container = new DIContainer();

            // Get the Service instance with the Repository dependency injected
            Service service = container.getInstance(Service.class);

            // Call the correct method
            service.performAction(); // This matches the method defined in Service class

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
