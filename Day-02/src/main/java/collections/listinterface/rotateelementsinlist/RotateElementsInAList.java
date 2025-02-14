package collections.listinterface.rotateelementsinlist;

import java.util.*;

public class RotateElementsInAList <T>{
    public static void main(String[] args) {
       //create list
       List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(8);
        System.out.println("original list : " + list);

        //rotate the list object create
        RotateElementsInAList<Integer> list2 = new RotateElementsInAList<>();

        //rotate the position
        List<Integer> list3 = list2.rotateElementsInList(list, 3);
        System.out.println(list3);

    }

    //method to rotate elements in a list
    public List<T> rotateElementsInList(List<T> list, int position){
        //check if linked list is already empty
       if (list == null || list.isEmpty()){
           return list;
       }

       //rotate the list
        for (int i=0;i<position;i++){
            T first = list.remove(0); //remove the first index element
            list.add(first); // add the element in last
        }
        return list;
    }
}
