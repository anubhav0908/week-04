package collections.listinterface.findnthelementfromtheend;
import java.io.FilterOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;

public class FindnthElement<T> {
    public static void main(String[] args) {
        //create linked list
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        System.out.println("linked list : " + list);

        //element find
        System.out.println();
        int n = 2;
        Character ch = findnthElement(list, n);

        System.out.println("Element is : " + ch);
    }

    //method to find nth element from end of list
    public static <T> T findnthElement(LinkedList<T> list, int n){
        //create iterator to iterator the linked list
        ListIterator<T> first = list.listIterator();
        ListIterator<T> last = list.listIterator();

        //check if the list s empty
        if(list == null || list.isEmpty()){
            return null;
        }
        //loop to move first pointer n position fast
        for(int i=0;i<n;i++){
            first.next(); //next pointer

        }
        while (first.hasNext()){
            first.next(); //iterate till has next node
            last.next();  //start moving last and first one position at time now
        }
        return last.next(); //return next pointer of last (n position)
    }
}
