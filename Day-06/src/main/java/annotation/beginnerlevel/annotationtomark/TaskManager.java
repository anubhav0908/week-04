package annotation.beginnerlevel.annotationtomark;

public class TaskManager {

    // Apply @ImportantMethod with default "HIGH" level
    @ImportantMethod
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    // Apply @ImportantMethod with a "LOW" importance level
    @ImportantMethod(level = "LOW")
    public void regularTask() {
        System.out.println("Executing regular task...");
    }

    // Apply @ImportantMethod with "MEDIUM" importance level
    @ImportantMethod(level = "MEDIUM")
    public void moderateTask() {
        System.out.println("Executing moderate task...");
    }
}

