package annotation.advancedlevel.rolebasedcontrol;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)  // Make it available at runtime
@Target(ElementType.METHOD)  // Apply this annotation to methods
public @interface RoleAllowed {
    String value();  // Specify the role required to access the method
}

