package collections.listinterface.reversealist;
import java.util.LinkedList;
import java.util.List;
public class ReverseLinkedList {
    //method to reverse linked list
  public static void reverseLinkedList(LinkedList<Integer> linkedList){
      int left = 0;
      int right = linkedList.size()-1;
      //looping till left right meet
      while (left < right){
          int temp = linkedList.get(left); //store value at left in temp
          linkedList.set(left, linkedList.get(right)); //get right element in left index
          linkedList.set(right, temp); //store temp in right index
          left++; right--;
      }
  }
}
