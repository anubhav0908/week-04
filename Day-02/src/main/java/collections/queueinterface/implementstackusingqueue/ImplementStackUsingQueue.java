package collections.queueinterface.implementstackusingqueue;
import java.util.*;
public class ImplementStackUsingQueue {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    // Push element onto the stack
    public void push(int x) {
        queue1.offer(x);
    }
    // pop the top element
    public int pop() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        // Move elements to queue2, except the last one
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.poll();

        // Swap queue1 and queue2 (so queue1 always has elements)
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }
    // Returns the top element without removing it
    public int top() {
        if (queue1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        // Peek at the last element
        int topElement = queue1.peek();
        queue2.offer(queue1.poll()); // Move it to queue2

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }
    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    public static void main(String[] args) {
        ImplementStackUsingQueue stack = new ImplementStackUsingQueue();
        //push element in stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
