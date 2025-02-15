package regex.extractionproblem.extractmail;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtracEmailAddress {
    public static void main(String[] args) {
        String regex = "[a-z]+@[a-z]+\\.[a-z]{3}";
        Pattern pattern = Pattern.compile(regex);

        String input = "Contact us at support@example.com and info@company.org";
        Matcher matcher = pattern.matcher(input);


        ArrayList<String> email = new ArrayList<>();
        while(matcher.find()){
          email.add(matcher.group());
        }

        for(String emails : email){
            System.out.println(emails);
        }

    }
}
