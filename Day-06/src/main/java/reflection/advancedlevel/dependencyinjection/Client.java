package reflection.advancedlevel.dependencyinjection;

public class Client {
    @Inject
    private Service service;

    public void performTask() {
        if (service != null) {
            service.serve();
        } else {
            System.out.println("Service is not injected.");
        }
    }
}
