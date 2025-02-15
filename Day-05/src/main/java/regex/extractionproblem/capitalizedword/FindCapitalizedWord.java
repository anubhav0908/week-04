package regex.extractionproblem.capitalizedword;

import java.util.ArrayList;
import java.util.SplittableRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCapitalizedWord {
    public static void main(String[] args) {
        String regex = "[A-Z][a-z]+";
        Pattern pattern = Pattern.compile(regex);

        String input = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        Matcher matcher = pattern.matcher(input);

        ArrayList<String> capital = new ArrayList<>();
        while (matcher.find()){
            capital.add(matcher.group());
        }

        for (String cap : capital){
            System.out.print(cap + " ");
        }
    }
}
