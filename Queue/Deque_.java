import java.util.*;
import java.util.LinkedList;

public class Deque_{
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // Adding elements to the deque
        deque.addFirst(1);
        deque.addLast(2);
        deque.offerFirst(0);
        deque.offerLast(3);

        System.out.println("Deque after additions: " + deque);

        // Removing elements from the deque
        int first = deque.removeFirst();
        int last = deque.removeLast();
        
        System.out.println("First element removed: " + first);
        System.out.println("Last element removed: " + last);
        System.out.println("Deque after removals: " + deque);

        // Examining elements in the deque
        int peekFirst = deque.peekFirst();
        int peekLast = deque.peekLast();
        
        System.out.println("First element in deque: " + peekFirst);
        System.out.println("Last element in deque: " + peekLast);
    }
}
