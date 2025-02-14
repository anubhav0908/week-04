package collections.mapinterface.wordfrequencycounter;
import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String fileName = "src/sample.txt";

        // count word frequency
        Map<String, Integer> wordFrequency = countWordFrequency(fileName);

        // print the result
        System.out.println("Word Frequency: " + wordFrequency);

    }
    public static Map<String, Integer> countWordFrequency(String fileName) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                // Split into words
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            //catch block to handle exception
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordCountMap;
    }
}
