package annotation.exercise4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define a custom annotation TaskInfo
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // Target this annotation to methods
public @interface TaskInfo {
    String priority();  // Priority field
    String assignedTo();  // Assigned person field
}

