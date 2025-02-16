package reflection.intermediatelevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)  // Makes it available at runtime
@Target(ElementType.TYPE)            // Can be applied to classes
public @interface Author {
    String name();  // Name of the author
}

