package regex.advanceproblem.extractcurrency;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCurrency {
    public static void main(String[] args) {
        String regex =  "(\\$?[1-9][0-9]?+\\.[0-9]+)|[1-9][0-9]?+\\.[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        String input = "The price is $45.99, and the discount is 10.50 , 5.00 .";

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
