package regex.extractionproblem.extractlinks;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void main(String[] args) {
        String regex = "https?://([a-z]+\\.)+[a-z]+";
        Pattern pattern = Pattern.compile(regex);

        String input = "Visit https://www.google.com and http://example.org for more info.";


        Matcher matcher = pattern.matcher(input);

        ArrayList<String> links = new ArrayList<>();
        while (matcher.find()){
            links.add(matcher.group());
        }

        for (String cap : links){
            System.out.print(cap + " ");
        }
    }
}
