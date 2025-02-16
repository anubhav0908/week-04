package annotation.exercise5;

import java.lang.annotation.*;

// Define the BugReport annotation with description
@Retention(RetentionPolicy.RUNTIME)  // Make the annotation available at runtime
@Target(ElementType.METHOD)  // Target this annotation to methods
@Repeatable(BugReports.class)  // Allow multiple instances of @BugReport
public @interface BugReport {
    String description();  // Description field for the bug report
}

