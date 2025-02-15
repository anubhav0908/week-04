package JavaStreams.consoletofile;

import java.io.*;

public class ConsoleToFile {
    public static void writeToFile(String filepath){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileWriter fileWriter = new FileWriter(filepath, true);

            // reading data from user
            System.out.print("Enter your name : ");
            String name = bufferedReader.readLine();

            System.out.print("Enter your age : ");
            int age = Integer.parseInt(bufferedReader.readLine());

            System.out.print("Enter favourite programming language : ");
            String language = bufferedReader.readLine();

            // writing data to file
            fileWriter.write("Name : " + name + "\n");
            fileWriter.write("Age : " + age + "\n");
            fileWriter.write("Language : " + language + "\n");

            fileWriter.flush();
            System.out.println("Written data successfully to file !!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String filepath = "userToConsole.txt";

        writeToFile(filepath);
    }
}
