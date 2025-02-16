package annotation.beginnerlevel.todoannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @Todo annotation with task description, assigned developer, and priority
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // Apply the annotation to methods
public @interface Todo {
    String task();  // Description of the pending task
    String assignedTo();  // Developer responsible for the task
    String priority() default "MEDIUM";  // Default priority is "MEDIUM"
}

