package collections.queueinterface.generatebinarynumbersusingqueue;
import java.util.*;
public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int N = 4; //define the number of binary numbers
        //create list and call the method
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
    //method to generate binary number
    public static List<String> generateBinaryNumbers(int N) { //method return a list of string
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer("1"); // Start with "1"

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result.add(current);
            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }
}
