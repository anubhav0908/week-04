package collections.listinterface.findfrequencyofelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinfFrequencyOfElements {
    public static void main(String[] args) {
       //create maps
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");
        //display frequency
        System.out.println();
        //call method to find frequency
        Map<String, Integer> result = findFrequency(list);
        System.out.println(result);
    }

     // method to find frequency
        public static Map<String, Integer> findFrequency(List<String> words) {
          //create map
            Map<String, Integer> frequencyMap = new HashMap<>();
            for (String value : words) {
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            }
           //return the frequency
            return frequencyMap;
        }
}
