package collections.setinterface.findsubset;

import java.util.HashSet;
import java.util.Set;

public class FindSubset {
    public static void main(String[] args) {
        //create sets
        Set<Integer> set1 = new HashSet<>();
        //add elements in set 1
        set1.add(2);
        set1.add(5);
        Set<Integer> set2 = new HashSet<>();
        //add elements in set 2
        set2.add(3);
        set2.add(2);
        set2.add(5);
        set2.add(7);
        System.out.println("is subset? : " + findSubset(set1, set2));

    }
    //method to find the subset(generic method)
    public static <T> boolean findSubset(Set<T> set1, Set<T> set2){
        for (T element : set1){
            //if any element missing return the false
            if(!set2.contains(element)){
                return false;
            }
        }
        return true; // else return true
    }
}
