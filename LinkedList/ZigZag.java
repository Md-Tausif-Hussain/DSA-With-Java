import java.util.*;

public class ZigZag {
    public static class Node { // structure of the linked_list
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // global_variable
    public static Node tail; // global_variable
    public static int size;

    public void addLast(int data){//this function have TimeComplexity of O(1)
        //step 1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
        head = tail = newNode ;
        return;
        }
        //step 2 -> connect to head
        tail.next = newNode;//linking 
        //step 3 -> 
        tail = newNode;
        
        }
    public void print() {
        if (head == null) {
            System.out.println("LL is Empty!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }
    public void Zig_Zag(){

        //Step 1 -> find Mid
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        Node mid = slow; // slow is my midNode

        //Step 2 -> reverse 2nd half 
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev ;//rigth half head
        Node left =  head;
        Node nextL , nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    public static void main(String[] args) {
        ZigZag ll = new ZigZag();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.print();  
        System.out.println(ll.size);

        ll.Zig_Zag();
        ll.print();
        
    }
}
