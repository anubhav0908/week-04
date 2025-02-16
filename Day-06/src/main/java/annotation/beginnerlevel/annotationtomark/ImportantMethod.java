package annotation.beginnerlevel.annotationtomark;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the ImportantMethod annotation with an optional 'level' parameter
@Retention(RetentionPolicy.RUNTIME)  // Ensure annotation is available at runtime
@Target(ElementType.METHOD)  // Target the annotation to methods
public @interface ImportantMethod {
    String level() default "HIGH";  // Default value for the level is "HIGH"
}

