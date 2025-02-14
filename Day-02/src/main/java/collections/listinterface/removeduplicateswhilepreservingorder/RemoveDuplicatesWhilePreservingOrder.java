package collections.listinterface.removeduplicateswhilepreservingorder;
import java.util.*;
public class RemoveDuplicatesWhilePreservingOrder {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        //add in arraylist
        list1.add(3);
        list1.add(2);
        list1.add(3);
        list1.add(6);
        System.out.println("original list: " + list1);
        //call method
        System.out.println("Integer List Output: " + removeDuplicates(list1));
    }
    //method to remove the duplicate element(generic method)
    public static <T> List<T> removeDuplicates(List<T> list) {
        //create new hashset and array list
        Set<T> set = new HashSet<>();
        List<T> result = new ArrayList<>();
        //iterate through each element
        for (T item : list) {
            if (set.add(item)) { // Add to result only if it's not seen before
                result.add(item);
            }
        }
        return result;
    }
}
