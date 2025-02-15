package JavaStreams.efficientfilecopy;

import java.io.*;

public class EfficientFileCopy {
    private static final int BUFFER_SIZE = 4096;

    public static void copyUsingFileStream(String source, String destination){
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

        File destinationFile = new File(destination);

        if (destinationFile.exists() && !destinationFile.canWrite()) {
            try {
                throw new IOException("Cannot write to destination file: " + destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(destination);

            int byteData;
            while ((byteData = fileInputStream.read()) != -1){
                fileOutputStream.write(byteData);
            }
            System.out.println("File copied successfully !!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyUsingBufferedStream(String source, String destination){
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;

        File destinationFile = new File(destination);

        if (destinationFile.exists() && !destinationFile.canWrite()) {
            try {
                throw new IOException("Cannot write to destination file: " + destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destination));

            byte[] buffer = new byte[BUFFER_SIZE];
            int byteData;
            while ((byteData = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(buffer, 0, byteData);
            }

            bufferedOutputStream.flush();
            System.out.println("File copied successfully !!");

        } catch (FileNotFoundException e) {
            System.out.println("File not found : " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String source = "source.txt";
        String destination = "destination.txt";

        long startTime = System.nanoTime();
        copyUsingBufferedStream(source, destination);
        long endTime = System.nanoTime();
        System.out.println("Time to copy contents using Buffered Streams : " + (endTime - startTime));

        startTime = System.nanoTime();
        copyUsingFileStream(source, destination);
        endTime = System.nanoTime();
        System.out.println("Time to copy contents using File Streams : " + (endTime - startTime));
    }
}
