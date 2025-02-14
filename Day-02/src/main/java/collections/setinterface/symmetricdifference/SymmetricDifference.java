package collections.setinterface.symmetricdifference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        //create sets
        Set<Integer> set1 = new HashSet<>();
        //add elements in set 1
        set1.add(1);
        set1.add(2);
        set1.add(6);
        Set<Integer> set2 = new HashSet<>();
        //add elements in set 2
        set2.add(3);
        set2.add(6);
        set2.add(7);

        Set<Integer> resultSet = findSymmetricDifference(set1, set2);
        System.out.println(resultSet);
    }
    //method to find symmetric difference (generic method)
    public static <T> Set<T> findSymmetricDifference(Set<T> set1, Set<T> set2){
        //create temp sets of same size
        Set<T> tempSet = new HashSet<>();
        //check for common element in set 1
        for (T value : set1){
            //if set 2 does not contain that element
            if (!set2.contains(value)){
                tempSet.add(value); //add value in tem set
            }
        }
        //check for common element in set 2
        for (T value : set2){
            //if set 1 does not contain that element
            if (!set1.contains(value)){
                tempSet.add(value); //add value in tem set
            }
        }
        return tempSet;
    }
}
