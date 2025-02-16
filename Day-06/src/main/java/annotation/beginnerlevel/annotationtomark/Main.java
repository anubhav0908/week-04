package annotation.beginnerlevel.annotationtomark;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the TaskManager class
            Class<?> taskManagerClass = TaskManager.class;

            // Get all methods in the TaskManager class
            Method[] methods = taskManagerClass.getDeclaredMethods();

            // Loop through each method and check for the @ImportantMethod annotation
            for (Method method : methods) {
                // Check if the method has the @ImportantMethod annotation
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    // Get the @ImportantMethod annotation
                    ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);

                    // Print method name and its importance level
                    System.out.println("Method: " + method.getName() + " | Importance Level: " + importantMethod.level());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

