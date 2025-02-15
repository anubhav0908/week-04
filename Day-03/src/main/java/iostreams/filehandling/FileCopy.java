package iostreams.filehandling;

import java.io.*;

public class FileCopy{
    public static void main(String[] args) {
        // Specify the source and destination file paths
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        // Initialize the streams
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Check if source file exists
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return; // Exit if source file does not exist
            }

            // Create a new destination file if it doesn't exist
            File dest = new File(destinationFile);
            if (!dest.exists()) {
                dest.createNewFile();
            }

            // Open FileInputStream for the source file
            fis = new FileInputStream(source);

            // Open FileOutputStream for the destination file
            fos = new FileOutputStream(dest);

            // Buffer for reading and writing data
            int byteData;

            // Read from source file and write to destination file byte by byte
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close streams to release resources
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
