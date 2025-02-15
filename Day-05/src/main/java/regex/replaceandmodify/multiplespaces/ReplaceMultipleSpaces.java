package regex.replaceandmodify.multiplespaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String input = "This is an   example with multiple spaces.";

        String replaced = input.replaceAll("\\s+", " ");

        System.out.println( "Before replacement " +input);
        System.out.println("After replacement " + replaced);



    }
}
