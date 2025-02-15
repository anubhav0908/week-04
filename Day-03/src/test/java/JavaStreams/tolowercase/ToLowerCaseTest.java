package JavaStreams.tolowercase;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ToLowerCaseTest {
    private static final String SOURCE_FILE = "source.txt";
    private static final String DESTINATION_FILE = "destination.txt";
    private static final String NON_EXISTENT_FILE = "nonexistent.txt";
    private static final String READ_ONLY_FILE = "readonly.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SOURCE_FILE))) {
            writer.write("Hello WORLD\nJAVA Programming\nTest CASE");
        }

        // Create a read-only destination file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(READ_ONLY_FILE))) {
            writer.write("Existing Content");
        }
        new File(READ_ONLY_FILE).setReadOnly();
    }

    @AfterEach
    void tearDown() {
        // Delete test files after each test
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
        File readOnlyFile = new File(READ_ONLY_FILE);
        readOnlyFile.setWritable(true);
        readOnlyFile.delete();
    }

    @Test
    void testToLowerCase_Success() throws IOException {
        ToLowerCase.toLowerCase(SOURCE_FILE, DESTINATION_FILE);

        assertTrue(new File(DESTINATION_FILE).exists(), "Destination file should be created.");

        // Normalize line endings and trim extra spaces
        String actualContent = readFileContent(DESTINATION_FILE).replace("\r\n", "\n").trim();

        assertEquals("hello world\njava programming\ntest case", actualContent, "Content should be in lowercase.");
    }


    @Test
    void testToLowerCase_EmptyFile() throws IOException {
        new FileWriter(SOURCE_FILE).close(); // Create an empty file

        ToLowerCase.toLowerCase(SOURCE_FILE, DESTINATION_FILE);

        assertTrue(new File(DESTINATION_FILE).exists(), "Empty file should be created.");
        assertEquals("", readFileContent(DESTINATION_FILE), "Destination file should also be empty.");
    }

    @Test
    void testToLowerCase_FileNotFound() {
        assertThrows(RuntimeException.class, () -> ToLowerCase.toLowerCase(NON_EXISTENT_FILE, DESTINATION_FILE));
    }

    @Test
    void testToLowerCase_ReadOnlyDestination() {
        assertThrows(RuntimeException.class, () -> ToLowerCase.toLowerCase(SOURCE_FILE, READ_ONLY_FILE));
    }

    private String readFileContent(String filePath) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(new File(filePath).toPath())).trim();
    }
}
