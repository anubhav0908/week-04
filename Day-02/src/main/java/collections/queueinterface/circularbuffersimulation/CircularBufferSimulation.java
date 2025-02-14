package collections.queueinterface.circularbuffersimulation;
import java.util.Arrays;
public class CircularBufferSimulation {
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    private int capacity;
   //constructor
    public CircularBufferSimulation(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }
    // add element into the circular buffer
    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity; // move tail forward in circular

        if (size < capacity) {
            size++; // increase size if not full
        } else {
            head = (head + 1) % capacity; // overwrite the oldest element
        }
    }
    // method to get the current elements in buffer
    public int[] getBuffer() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = buffer[(head + i) % capacity];
        }
        return result;
    }
    public static void main(String[] args) {
        //create instance of class
        CircularBufferSimulation cb= new CircularBufferSimulation(3);

        // insert elements in buffer
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        System.out.println("Buffer after inserting 1, 2, 3: " + Arrays.toString(cb.getBuffer()));

        // add additional element (overwriting oldest)
        cb.insert(4);
        System.out.println("Buffer after inserting 4: " + Arrays.toString(cb.getBuffer()));
       // add another additional element (overwriting oldest)
        cb.insert(5);
        System.out.println("Buffer after inserting 5: " + Arrays.toString(cb.getBuffer()));
    }
}
