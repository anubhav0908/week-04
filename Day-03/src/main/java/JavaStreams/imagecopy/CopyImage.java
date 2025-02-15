package JavaStreams.imagecopy;

import java.io.*;

public class CopyImage {
    public static byte[] ImageToByteArray(String source) throws IOException {

        byte[] buffer = new byte[4096];     // buffer to read data
        int bytesRead;

        try(FileInputStream fileInputStream = new FileInputStream(source);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){

            while ((bytesRead = fileInputStream.read(buffer)) != -1){       // while
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BytesToImage(byte[] imagedata, String destination){

        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imagedata);
        FileOutputStream fileOutputStream = new FileOutputStream(destination)){

            byte[] buffer = new byte[4096];
            int bytesRead;

            while((bytesRead = byteArrayInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Image converted successfully !!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String source = "Untitled design (5).png";
        String destination = "Untitled design Copy.png";

        // converting iomage to bytes array
        byte[] bytesRead = ImageToByteArray(source);

        BytesToImage(bytesRead, destination);
    }
}
