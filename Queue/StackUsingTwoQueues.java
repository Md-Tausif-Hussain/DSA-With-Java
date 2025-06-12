import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    static class Stack {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();

        // Push operation
        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // Pop operation
        public int pop() {
            if (empty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // Top operation
        public int top() {
            if (empty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

        // Empty operation
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top()); // Output: 3
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.pop()); // Output: 2
        System.out.println(stack.top()); // Output: 1
        System.out.println(stack.pop()); // Output: 1
        System.out.println(stack.empty()); // Output: true
    }
}
