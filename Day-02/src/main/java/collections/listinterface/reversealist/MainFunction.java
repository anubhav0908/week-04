package collections.listinterface.reversealist;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainFunction {
    public static void main(String[] args) {
     //create an array list
        ArrayList<Integer> arrayList = new ArrayList<>();
        //add elements in list
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(1);
        System.out.println("original list:" + arrayList);

        System.out.print("Reversed list: " );
        //call the reverse array list method
         ReverseArrayList.reverseArrayList(arrayList);
        System.out.println(arrayList);

        //create linked list
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(9);
        System.out.println("original linked list: " + linkedList);

        System.out.print("Reversed list: " );
        //call the reverse linked list method
        ReverseLinkedList.reverseLinkedList(linkedList);
        System.out.println(linkedList);
    }
}
