package collections.mapinterface.mergetwomaps;
import java.util.*;
public class MergeTwoMaps {
    public static void main(String[] args) {
        // create maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1); //add elements in map
        map1.put("B", 2);
        System.out.println("Map 1: " + map1);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        System.out.println("Map 2: " + map2);
        //method call to merge two maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println("Merged Map: " + mergedMap);
    }
    //method to merge two maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>();

        // add all elements from map1
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }

        // add elements from map2
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (mergedMap.containsKey(key)) {
                mergedMap.put(key, mergedMap.get(key) + value); // Sum values
            } else {
                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }
}
