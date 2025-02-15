package JavaStreams.consoletofile;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleToFileTest {

    private static final String TEST_FILE_PATH = "E:\\test_userToConsole.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Ensure test file is empty before each test
        new File(TEST_FILE_PATH).delete();
    }

    @AfterEach
    void tearDown() {
        // Clean up test file after test runs
        new File(TEST_FILE_PATH).delete();
    }

    @Test
    void testWriteToFile() throws IOException {
        // Mock user input
        String simulatedInput = "John\n25\nJava\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the method
        ConsoleToFile.writeToFile(TEST_FILE_PATH);

        // Verify file content
        File testFile = new File(TEST_FILE_PATH);
        assertTrue(testFile.exists(), "Test file should be created");

        // Read content
        String content = new String(java.nio.file.Files.readAllBytes(testFile.toPath()));

        // Expected output
        String expectedOutput = "Name : John\nAge : 25\nLanguage : Java\n";

        // Verify content matches
        assertEquals(expectedOutput, content, "File content should match expected output");
    }

}
