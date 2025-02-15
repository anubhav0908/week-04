package junittesting.basictesting.stringutility;

public class StringUtils {

    // Method to reverse the string
    public static String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);  // Reuse the reverse method
        return str.equals(reversed);
    }

    // Method to convert string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

