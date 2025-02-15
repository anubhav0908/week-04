package exceptions.multiplecatchblocks;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ArrayOperations {
    public static void accessArray(Integer[] array, int index) {
        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Integer[] numbers = {10, 20, 30, 40, 50};
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();
            accessArray(numbers, index);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a numeric index.");
        }
    }
}
