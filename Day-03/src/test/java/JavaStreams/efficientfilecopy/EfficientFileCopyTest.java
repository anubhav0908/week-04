package JavaStreams.efficientfilecopy;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class EfficientFileCopyTest {

    private static final String SOURCE_FILE = "E:\\source.txt";
    private static final String DESTINATION_FILE = "E:\\destination.txt";
    private static final String NON_EXISTENT_FILE = "non_existent.txt";
    private static final String READ_ONLY_FILE = "E:\\readonly.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (FileWriter writer = new FileWriter(SOURCE_FILE)) {
            writer.write("Hello, this is a test file.");
        }

        // Create a read-only file
        try (FileWriter writer = new FileWriter(READ_ONLY_FILE)) {
            writer.write("This is a read-only file.");
        }
        new File(READ_ONLY_FILE).setReadOnly();
    }

    @AfterEach
    void tearDown() {
        // Delete test files after each test
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
        File readOnlyFile = new File(READ_ONLY_FILE);
        readOnlyFile.setWritable(true); // Remove read-only attribute before deleting
        readOnlyFile.delete();
    }

    @Test
    void testCopyUsingFileStream() throws IOException {
        EfficientFileCopy.copyUsingFileStream(SOURCE_FILE, DESTINATION_FILE);

        // Verify file exists
        File destFile = new File(DESTINATION_FILE);
        assertTrue(destFile.exists(), "Destination file should be created");

        // Verify content matches
        assertEquals(readFileContent(SOURCE_FILE), readFileContent(DESTINATION_FILE),
                "File content should be the same");
    }

    @Test
    void testFileNotFoundExceptionForSource_FileStream() {
        assertDoesNotThrow(() -> EfficientFileCopy.copyUsingFileStream(NON_EXISTENT_FILE, DESTINATION_FILE));
    }

    @Test
    void testFileNotFoundExceptionForSource_BufferedStream() {
        assertDoesNotThrow(() -> EfficientFileCopy.copyUsingBufferedStream(NON_EXISTENT_FILE, DESTINATION_FILE));
    }

    @Test
    void testIOExceptionForReadOnlyDestination_FileStream() {
        assertThrows(RuntimeException.class, () -> EfficientFileCopy.copyUsingFileStream(SOURCE_FILE, READ_ONLY_FILE));
    }

    @Test
    void testIOExceptionForReadOnlyDestination_BufferedStream() {
        assertThrows(RuntimeException.class, () -> EfficientFileCopy.copyUsingBufferedStream(SOURCE_FILE, READ_ONLY_FILE));
    }

    @Test
    void testEmptySourceFileCopy_FileStream() throws IOException {
        createEmptyFile(SOURCE_FILE);
        EfficientFileCopy.copyUsingFileStream(SOURCE_FILE, DESTINATION_FILE);
        assertTrue(new File(DESTINATION_FILE).exists(), "Empty file should be copied successfully.");
    }

    @Test
    void testEmptySourceFileCopy_BufferedStream() throws IOException {
        createEmptyFile(SOURCE_FILE);
        EfficientFileCopy.copyUsingBufferedStream(SOURCE_FILE, DESTINATION_FILE);
        assertTrue(new File(DESTINATION_FILE).exists(), "Empty file should be copied successfully.");
    }

    private void createEmptyFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("");
        }
    }

    private String readFileContent(String filePath) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(new File(filePath).toPath()));
    }
}
