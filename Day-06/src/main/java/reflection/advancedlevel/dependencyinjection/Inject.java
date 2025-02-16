package reflection.advancedlevel.dependencyinjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  // Keep the annotation at runtime for reflection
public @interface Inject {
}
