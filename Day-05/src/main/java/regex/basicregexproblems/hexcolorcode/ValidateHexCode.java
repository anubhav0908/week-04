package regex.basicregexproblems.hexcolorcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexCode {
    public static void main(String[] args) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        String input = "#FFa489";
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println("Valid");
        }else {
            System.out.println("Invalid");
        }
    }
}
