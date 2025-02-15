package regex.advanceproblem.repeatingword;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWord {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        String input = "This is is a repeated repeated word test.";
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            if(set.contains(matcher.group())){
                System.out.println(matcher.group());
            }else {
                set.add(matcher.group());
            }
        }

    }
}
