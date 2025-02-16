package annotation.advancedlevel.customserialization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)  // Retain at runtime for reflection
@Target(ElementType.FIELD)  // Apply this annotation to fields
public @interface JsonField {
    String name();  // The custom name for the JSON key
}
