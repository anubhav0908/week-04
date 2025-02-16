package reflection.advancedlevel.customloggingproxy;

import java.lang.reflect.Proxy;

public class ProxyExample {
    public static void main(String[] args) {
        // Create the original object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create the logging handler that wraps the original object
        LoggingInvocationHandler handler = new LoggingInvocationHandler(greeting);

        // Create a dynamic proxy for the Greeting interface
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                handler
        );

        // Invoke the method on the proxy (this will log the method name first)
        proxyGreeting.sayHello();
    }
}
