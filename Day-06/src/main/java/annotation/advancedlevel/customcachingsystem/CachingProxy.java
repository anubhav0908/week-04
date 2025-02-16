package annotation.advancedlevel.customcachingsystem;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CachingProxy implements InvocationHandler {

    private final Object target;

    // Constructor to set the target object (i.e., ExpensiveComputation)
    public CachingProxy(Object target) {
        this.target = target;
    }

    // Create and return a proxy instance
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),  // Make sure it implements the interface
                new CachingProxy(target));
    }

    // Intercept method calls
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Check if the method is annotated with @CacheResult
        if (method.isAnnotationPresent(CacheResult.class)) {
            // Check if the result is already cached
            Object cachedResult = CacheManager.getCachedResult(method, args);
            if (cachedResult != null) {
                System.out.println("Returning cached result...");
                return cachedResult;  // Return cached result
            }

            // If not cached, invoke the method
            Object result = method.invoke(target, args);

            // Cache the result for future calls
            CacheManager.storeResult(method, args, result);
            return result;
        }

        // If the method isn't annotated with @CacheResult, invoke it normally
        return method.invoke(target, args);
    }
}
