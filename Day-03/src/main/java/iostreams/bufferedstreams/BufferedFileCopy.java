package iostreams.bufferedstreams;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "source_large_file.txt"; // Replace with your large file path
        String destinationFile = "destination_large_file_buffered.txt"; // Output file

        // Create Buffered Streams
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            // Read and write in 4 KB chunks
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Measure the start time
            long startTime = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            // Measure the end time
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Buffered file copy completed.");
            System.out.println("Time taken (Buffered Streams): " + duration + " nanoseconds.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
