package reflection.advancedlevel.customloggingproxy;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}
