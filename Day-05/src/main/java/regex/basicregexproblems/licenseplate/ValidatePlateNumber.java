package regex.basicregexproblems.licenseplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePlateNumber {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        String input = "AB1234";
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println("Valid");
        }else {
            System.out.println("Invalid");
        }
    }
}
