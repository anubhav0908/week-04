package annotation.beginnerlevel.todoannotation;

public class ProjectTasks {

    // Apply @Todo annotation to a method with task details
    @Todo(task = "Implement user authentication", assignedTo = "Om Prakash", priority = "HIGH")
    public void userAuthentication() {
        System.out.println("User authentication feature is pending.");
    }

    // Apply @Todo annotation with default priority "MEDIUM"
    @Todo(task = "Design database schema", assignedTo = "Apna")
    public void databaseSchemaDesign() {
        System.out.println("Database schema design is pending.");
    }

    // Apply @Todo annotation with a task and assigned developer but with "LOW" priority
    @Todo(task = "Update user profile UI", assignedTo = "Furquan", priority = "LOW")
    public void userProfileUIUpdate() {
        System.out.println("User profile UI update is pending.");
    }
}

