import java.util.*;
import java.util.LinkedList;

public class ReverseQueue {
    
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Transfer elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Transfer elements back from stack to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue: " + queue);

        reverseQueue(queue);

        System.out.println("Reversed Queue: " + queue);
    }
}
