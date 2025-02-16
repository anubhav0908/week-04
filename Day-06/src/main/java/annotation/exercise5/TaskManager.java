package annotation.exercise5;

public class TaskManager {

    // Apply @BugReport annotation twice on the same method
    @BugReport(description = "Null pointer exception on user login.")
    @BugReport(description = "Page not loading in certain browsers.")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

