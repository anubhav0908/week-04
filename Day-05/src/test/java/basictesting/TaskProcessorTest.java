package basictesting;

import junittesting.basictesting.performancetesting.TaskProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class TaskProcessorTest {

    private final TaskProcessor taskProcessor = new TaskProcessor();

    // Test to verify that the longRunningTask() method fails if it takes more than 2 seconds
    @Test
    @Timeout(value = 2)  // Timeout after 2 seconds
    void testLongRunningTask() throws InterruptedException {
        String result = taskProcessor.longRunningTask();
        assertEquals("Task Completed", result);  // Verifies that the task completes correctly
    }
}

