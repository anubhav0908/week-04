package regex.advanceproblem.validatessn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        String input = "My SSN is 123-45-6789, 234-45-6789";
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){

                System.out.println("valid ssn " + matcher.group());

        }
    }
}
