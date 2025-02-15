package basictesting;

import junittesting.basictesting.filehandling.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private FileProcessor fileProcessor;
    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        fileProcessor = new FileProcessor();
        tempFile = Files.createTempFile("testFile", ".txt");  // Create a temporary file for testing
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);  // Delete the temporary file after each test
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, world!";

        // Write content to the file
        fileProcessor.writeToFile(tempFile.toString(), content);

        // Read the content from the file
        String readContent = fileProcessor.readFromFile(tempFile.toString());

        // Verify that the written and read content are the same
        assertEquals(content, readContent, "The content read from the file should match the written content.");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        String content = "File existence check!";

        // Write content to the file
        fileProcessor.writeToFile(tempFile.toString(), content);

        // Verify that the file exists
        assertTrue(Files.exists(tempFile), "The file should exist after writing content to it.");
    }

    @Test
    void testIOExceptionForNonExistentFile() {
        // Create a path for a non-existent file
        Path nonExistentFile = Paths.get("nonExistentFile.txt");

        // Verify that reading from a non-existent file throws an IOException
        assertThrows(IOException.class, () -> fileProcessor.readFromFile(nonExistentFile.toString()),
                "Reading from a non-existent file should throw an IOException.");
    }
}

