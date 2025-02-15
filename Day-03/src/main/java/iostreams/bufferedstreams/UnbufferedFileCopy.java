package iostreams.bufferedstreams;

import java.io.*;

public class UnbufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source_large_file.txt"; // Replace with your large file path
        String destinationFile = "destination_large_file_unbuffered.txt"; // Output file

        // Create Unbuffered Streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            // Read and write in 4 KB chunks
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Measure the start time
            long startTime = System.nanoTime();

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Measure the end time
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Unbuffered file copy completed.");
            System.out.println("Time taken (Unbuffered Streams): " + duration + " nanoseconds.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
