package regex.advanceproblem.validateipaddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {
    public static void main(String[] args) {
        String regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)";
        Pattern pattern  = Pattern.compile(regex);
        String input = "252.168.1.1";
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println("valid IP Address");
        }else {
            System.out.println("Not Valid Ip Address");
        }
    }
}
