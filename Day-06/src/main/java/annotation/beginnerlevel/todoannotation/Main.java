package annotation.beginnerlevel.todoannotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the ProjectTasks class
            Class<?> projectTasksClass = ProjectTasks.class;

            // Get all methods in the ProjectTasks class
            Method[] methods = projectTasksClass.getDeclaredMethods();

            // Loop through each method and check for the @Todo annotation
            for (Method method : methods) {
                // Check if the method has the @Todo annotation
                if (method.isAnnotationPresent(Todo.class)) {
                    // Get the @Todo annotation
                    Todo todo = method.getAnnotation(Todo.class);

                    // Print the details of the pending task
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println("Method: " + method.getName());
                    System.out.println("------------------------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
