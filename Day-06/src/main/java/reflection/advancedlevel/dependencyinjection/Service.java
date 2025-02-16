package reflection.advancedlevel.dependencyinjection;

public class Service {
    private Repository repository;

    // Constructor with dependency injection
    public Service(Repository repository) {
        this.repository = repository;
    }
    public void serve() {
        System.out.println("Serving the service.");
    }


    // Method that performs some action
    public void performAction() {
        System.out.println("Service is performing an action.");
        repository.execute();
    }
}
