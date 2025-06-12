import java.util.*;

public class TwoStacks{
    static class Queue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Check if the queue is empty
        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        // Add TimeComplexity -> O(n)
        public void add(int data) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        // Remove TimeComplexity -> O(1)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return stack1.pop();
        }

        //peek TimeComplexity -> O(1)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            return stack1.peek();
        }

        
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
