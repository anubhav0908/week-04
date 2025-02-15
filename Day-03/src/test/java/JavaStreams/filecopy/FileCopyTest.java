package JavaStreams.filecopy;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileCopyTest {

    private static final String SOURCE_FILE = "test_source.txt";
    private static final String DESTINATION_FILE = "test_destination.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (FileWriter writer = new FileWriter(SOURCE_FILE)) {
            writer.write("Hello, this is a test file.");
        }
    }

    @AfterEach
    void tearDown() {
        // Delete the test files after each test
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
    }

    @Test
    void testFileCopySuccess() throws IOException {
        FileCopy.fileCopy(SOURCE_FILE, DESTINATION_FILE);

        // Check if destination file exists
        File destFile = new File(DESTINATION_FILE);
        assertTrue(destFile.exists(), "Destination file should be created");

        // Check if content matches
        String sourceContent = readFileContent(SOURCE_FILE);
        String destContent = readFileContent(DESTINATION_FILE);
        assertEquals(sourceContent, destContent, "File content should be the same");
    }

    @Test
    void testFileNotFound() {
        String nonExistentFile = "non_existent.txt";
        assertDoesNotThrow(() -> FileCopy.fileCopy(nonExistentFile, DESTINATION_FILE));
    }

    private String readFileContent(String filePath) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(new File(filePath).toPath()));
    }
}
