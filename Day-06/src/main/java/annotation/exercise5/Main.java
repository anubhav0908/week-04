package annotation.exercise5;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> taskManagerClass = TaskManager.class;

            // Get the method that is annotated with @BugReport
            Method method = taskManagerClass.getMethod("processTask");

            // Check if the method has any @BugReports annotations
            if (method.isAnnotationPresent(BugReports.class)) {
                // Get the BugReports container annotation
                BugReports bugReports = method.getAnnotation(BugReports.class);

                // Iterate through each BugReport and print the description
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Description: " + bugReport.description());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

