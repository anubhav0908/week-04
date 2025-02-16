package annotation.advancedlevel.customcachingsystem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)  // Retain the annotation at runtime
@Target(ElementType.METHOD)  // Apply to methods
public @interface CacheResult {
}

