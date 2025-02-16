package annotation.exercise4;

public class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Om Prakash")  // Apply annotation to a method
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

