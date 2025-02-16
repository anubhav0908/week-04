package annotation.exercise4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> taskManagerClass = TaskManager.class;

            // Get the method that is annotated with @TaskInfo
            Method method = taskManagerClass.getMethod("completeTask");

            // Check if the method has the TaskInfo annotation
            if (method.isAnnotationPresent(TaskInfo.class)) {
                // Get the annotation
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                // Retrieve and print the annotation details
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
