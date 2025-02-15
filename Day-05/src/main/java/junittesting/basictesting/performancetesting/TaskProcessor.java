package junittesting.basictesting.performancetesting;

public class TaskProcessor {

    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);  // Simulates a task that takes 3 seconds
        return "Task Completed";
    }
}

