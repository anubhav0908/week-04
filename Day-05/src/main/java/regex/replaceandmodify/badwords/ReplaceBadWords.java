package regex.replaceandmodify.badwords;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceBadWords {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("damn");
        set.add("stupid");

        String regex = "\\b\\w+\\b";
        Pattern pattern = Pattern.compile(regex);
        String input = "This is a damn bad example with some stupid words.";

        Matcher matcher = pattern.matcher(input);
        String replaced="";

        while (matcher.find()){
            if(set.contains(matcher.group())){
                replaced += " **** ";
            }else {
                replaced += matcher.group() ;
                replaced += " ";
            }

        }

        System.out.println(replaced);


    }
}
