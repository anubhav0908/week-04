package regex.advanceproblem.extractprogramminglanguage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLanguage {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("Java", "C++", "Ruby", "Python","JavaScript", "Go"));
        String regex = "\\b\\w+\\b";

        Pattern pattern = Pattern.compile(regex);
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        Matcher matcher = pattern.matcher(input);
        ArrayList<String> language = new ArrayList<>();

        while(matcher.find()){
            if(set.contains(matcher.group())){
                language.add(matcher.group());
            }
        }

        for(String lang : language){
            System.out.println(lang);
        }

    }
}
