package collections.setinterface.unionandintersectionoftwosets;
import java.util.*;
public class UnionAndIntersection {
    public static void main(String[] args) {
        //create sets
        Set<Integer> set1 = new HashSet<>();
        //add elements in set 1
        set1.add(1);
        set1.add(2);
        set1.add(6);
        System.out.println("set 1:" + set1);
        Set<Integer> set2 = new HashSet<>();
        //add elements in set 2
        set2.add(5);
        set2.add(8);
        set2.add(2);
        System.out.println("set 2: " + set2);
        //find union
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); //add all elements of set 2
        // find intersection
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // retain only common element

        System.out.println("Union of sets: " + unionSet);
        System.out.println("Intersection of sets: " + intersectionSet);
    }

}
