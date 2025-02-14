package collections.mapinterface.findthekeywithhighestvalue;
import java.util.*;
public class FindKeyWithHighestValue {
    public static void main(String[] args) {
        // create a map
        Map<String, Integer> map = new HashMap<>();
        //add elements in map
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        map.put("D", 40);
        System.out.println("map is: " + map);
        // find the key with the highest value method call
        String maxKey = findHighestKey(map);

        // print the result
        System.out.println("Key with the highest value: " + maxKey);
    }
    //method to find the highest key
    public static String findHighestKey(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return null; // return null if the map is empty
        }

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
