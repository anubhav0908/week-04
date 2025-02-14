package collections.listinterface.reversealist;
import java.util.ArrayList;
public class ReverseArrayList {
    //method to reverse the arraylist
    public static void reverseArrayList(ArrayList<Integer> arrayList){
        int left = 0;
        int right = arrayList.size()-1;
        //looping till left right meeth
        while (left < right){
            //swap the elements
          int temp = arrayList.get(left); //store value at left in temp
          arrayList.set(left, arrayList.get(right)); //get right element in left index
          arrayList.set(right, temp); //store temp in right index
           left++; right--;
        }
    }
}
