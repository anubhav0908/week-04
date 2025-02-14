package mapinterface.wordfrequencycounter;

import collections.mapinterface.wordfrequencycounter.WordFrequencyCounter;
import org.junit.Test;
import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class test
{

    @Test
    public void testCountWordFrequency() throws IOException {
        // Create a temporary test file
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();

        // Write sample content to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Hello world! Hello Java.");
        }

        // Expected output
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        // Call method and verify
        assertEquals(expected, WordFrequencyCounter.countWordFrequency(tempFile.getAbsolutePath()));
    }
}
