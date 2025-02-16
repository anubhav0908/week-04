package annotation.advancedlevel.customcachingsystem;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// CacheManager to store cached results
public class CacheManager {

    // HashMap to store cached results
    private static final Map<String, Object> cache = new HashMap<>();

    // Method to check and store cached result
    public static Object getCachedResult(Method method, Object[] args) {
        // Create a unique key based on method name and arguments
        String key = generateKey(method, args);

        // Check if the result is already cached
        if (cache.containsKey(key)) {
            return cache.get(key);  // Return the cached result
        }

        return null;  // Return null if no cache entry found
    }

    // Method to store a result in the cache
    public static void storeResult(Method method, Object[] args, Object result) {
        String key = generateKey(method, args);
        cache.put(key, result);  // Store the result in cache
    }

    // Helper method to generate a unique key for the cache based on method and arguments
    private static String generateKey(Method method, Object[] args) {
        StringBuilder key = new StringBuilder(method.getName());

        for (Object arg : args) {
            key.append("-").append(arg.toString());  // Append each argument to the key
        }

        return key.toString();
    }
}

