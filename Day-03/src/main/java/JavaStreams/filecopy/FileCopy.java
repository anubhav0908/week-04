package JavaStreams.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void fileCopy(String source, String destination){
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;

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

    public static void main(String[] args) {
        String source = "source.txt";
        String destination = "destination.txt";

        fileCopy(source, destination);
    }
}
