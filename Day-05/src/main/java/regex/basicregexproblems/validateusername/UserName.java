package regex.basicregexproblems.validateusername;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserName {
    public static void main(String[] args) {

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        String input =  "user_1231111181";
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            System.out.println("Valid username");
        }else {
            System.out.println("Invalid username");
        }
    }
}
