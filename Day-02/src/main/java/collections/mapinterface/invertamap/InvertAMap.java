package collections.mapinterface.invertamap;
import java.util.*;
public class InvertAMap {
    public static void main(String[] args) {
        // create map
        Map<String, Integer> originalMap = new HashMap<>();
        //add elements in map
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        System.out.println("original map: " + originalMap);
        // Invert the map method call
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Print the result
        System.out.println("Inverted Map: " + invertedMap);
    }
    //method to invert map(Generic type)
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        //create another map
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            // if value is not present then create a new list
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }

            // add the key to the list for this value
            invertedMap.get(value).add(key);
        }
        return invertedMap;
    }
}
