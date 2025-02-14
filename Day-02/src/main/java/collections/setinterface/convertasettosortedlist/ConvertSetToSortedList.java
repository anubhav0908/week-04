package collections.setinterface.convertasettosortedlist;
import java.util.*;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        //create hash set
        HashSet<Integer> set1 = new HashSet<>();
        //add elements in set 1
        set1.add(1);
        set1.add(2);
        set1.add(8);
        set1.add(6);
        //create a list
        List<Integer> sortedList = convertToList(set1);
        System.out.println("Sorted list is: " + sortedList);
    }

    //method to convert set to sorted list
    public static <T extends Comparable> List<T> convertToList(HashSet<T> set) {
        //create an array list to add hash set element
        List<T> list1 = new ArrayList<>(set);
        //sort the list
       Collections.sort(list1);
      //return the sorted list
        return list1;
    }
}
