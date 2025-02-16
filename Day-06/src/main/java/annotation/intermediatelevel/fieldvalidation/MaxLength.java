package annotation.intermediatelevel.fieldvalidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the @MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)  // Make it available at runtime
@Target(ElementType.FIELD)  // Apply this annotation to fields
public @interface MaxLength {
    int value();  // Maximum length for the string field
}
