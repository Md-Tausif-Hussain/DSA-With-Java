import java.util.Stack;
//Time Complexity  : O(n)
//Space Complexity: O(n)
public class PalindromeLinkedlist {
    
    static class Node {
        int data;
        Node ptr;
        
        Node(int d) {
            ptr = null;
            data = d;
        }
    }
    
    static boolean isPalindrome(Node head) {
        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();
        
        // Push all elements of the list to the stack
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }
        
        // Traverse the list again and check with elements popped from the stack
        while (head != null) {
            int i = stack.pop();
            if (head.data != i) {
                ispalin = false;
                break;
            }
            head = head.ptr;
        }
        
        return ispalin;
    }
    
    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;
        
        boolean condition = isPalindrome(one);
        System.out.println("Palindrome: " + condition);
    }
}
