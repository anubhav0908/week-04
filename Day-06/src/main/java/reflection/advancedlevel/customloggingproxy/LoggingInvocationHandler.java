package reflection.advancedlevel.customloggingproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingInvocationHandler implements InvocationHandler {
    private Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log the method name before calling it
        System.out.println("Calling method: " + method.getName());

        // Invoke the original method on the target object
        return method.invoke(target, args);
    }
}

