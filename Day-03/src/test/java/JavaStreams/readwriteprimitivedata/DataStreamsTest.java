package JavaStreams.readwriteprimitivedata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataStreamsTest {
    private static final String TEST_FILE = "test_data.bin";  // Use binary file extension

    private final List<Student> testStudents = Arrays.asList(
            new Student(1, "Alice", 8.7),
            new Student(2, "Bob", 8.3),
            new Student(3, "Charlie", 9.1)
    );

    @BeforeEach
    void setUp() {
        // Write test data before each test
        DataStreams.writeData(TEST_FILE, testStudents);
    }

    @AfterEach
    void tearDown() {
        // Delete test file after each test
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteData_Success() {
        File file = new File(TEST_FILE);
        assertTrue(file.exists(), "File should be created after writing data.");
        assertTrue(file.length() > 0, "File should not be empty.");
    }

    @Test
    void testReadData_Success() throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(TEST_FILE))) {
            assertTrue(dataInputStream.available() > 0, "File should contain data.");

            for (Student expectedStudent : testStudents) {
                int rollNumber = dataInputStream.readInt();
                String name = dataInputStream.readUTF();
                double gpa = dataInputStream.readDouble();

                assertEquals(expectedStudent.getRollNumber(), rollNumber);
                assertEquals(expectedStudent.getName(), name);
                assertEquals(expectedStudent.getGpa(), gpa, 0.01);
            }
        }
    }
}
