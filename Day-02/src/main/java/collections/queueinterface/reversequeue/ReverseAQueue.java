package collections.queueinterface.reversequeue;
import java.util.Collection;
import java.util.Iterator;
import java.util.*;

public class ReverseAQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30, 40));

        System.out.println("Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }

    public static <T> void reverseQueue(Queue<T> queue) {
        //using recursion
        if (queue.isEmpty()) {
            return;
        }
        T front = queue.remove();

        reverseQueue(queue);

        queue.add(front);
    }

}