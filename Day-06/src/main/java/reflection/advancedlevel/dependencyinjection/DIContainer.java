package reflection.advancedlevel.dependencyinjection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class DIContainer {
    private Map<Class<?>, Object> cache = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        // Check if the instance is already created
        if (cache.containsKey(clazz)) {
            return clazz.cast(cache.get(clazz));
        }

        // Get all constructors of the class
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        // Assume the class has one constructor
        Constructor<?> constructor = constructors[0]; // Select the first constructor for simplicity

        // Get the parameter types for the constructor
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] params = new Object[parameterTypes.length];

        // Iterate over the parameter types and create instances for them
        for (int i = 0; i < parameterTypes.length; i++) {
            params[i] = getInstance(parameterTypes[i]); // Recursively get instances for constructor params
        }

        // Create the instance of the class
        T instance = clazz.cast(constructor.newInstance(params));

        // Cache the instance for future use
        cache.put(clazz, instance);

        return instance;
    }

    // Create an instance without any parameters if needed
    public <T> T createInstance(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        return constructor.newInstance();
    }
}

