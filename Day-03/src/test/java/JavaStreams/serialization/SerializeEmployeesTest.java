package JavaStreams.serialization;

import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class SerializeEmployeesTest {

    private static final String FILE_PATH = "testSerializeEmployee.txt";
    private static final String CORRUPT_FILE_PATH = "corruptFile.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Clean up before each test
        new File(FILE_PATH).delete();
        new File(CORRUPT_FILE_PATH).delete();
    }

    @AfterEach
    void tearDown() {
        // Delete test files after execution
        new File(FILE_PATH).delete();
        new File(CORRUPT_FILE_PATH).delete();
    }

    @Test
    void testSerializeEmployees() {
        SerializeEmployees.serializeEmployees(FILE_PATH);

        // Check if file is created
        File file = new File(FILE_PATH);
        assertTrue(file.exists(), "Serialized file should exist.");
    }

    @Test
    void testDeserializeEmployees() {
        SerializeEmployees.serializeEmployees(FILE_PATH);

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SerializeEmployees.deserializeEmployees(FILE_PATH);

        // Reset System.out
        System.setOut(System.out);

        // Check output contains expected employee details
        String output = outputStream.toString();
        assertTrue(output.contains("Brandon"), "Output should contain employee name Brandon.");
        assertTrue(output.contains("Bob"), "Output should contain employee name Bob.");
        assertTrue(output.contains("Ash"), "Output should contain employee name Ash.");
    }

    @Test
    void testDeserializeNonExistentFile() {
        // Should handle the exception gracefully
        assertDoesNotThrow(() -> SerializeEmployees.deserializeEmployees("E:\\nonExistent.txt"));
    }

    @Test
    void testDeserializeCorruptFile() throws IOException {
        // Create a corrupt file
        try (FileWriter writer = new FileWriter(CORRUPT_FILE_PATH)) {
            writer.write("This is not a serialized object.");
        }

        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SerializeEmployees.deserializeEmployees(CORRUPT_FILE_PATH);

        // Reset System.out
        System.setOut(System.out);

        // Verify that the error message is printed
        String output = outputStream.toString();
        assertTrue(output.contains("Error"), "Error message should be printed for corrupt file.");
    }
}
