import java.util.*;
import java.util.LinkedList;

public class Reverse {
    public static class Node{//structure of the linked_list
        int data;
        Node next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;//global_variable
    public static Node tail;//global_variable
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

        public void print(){
            if(head == null){
                System.out.println("LL is Empty !");
                return ;
            }
            Node temp = head;
            while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
            }
            System.out.println("Null");
        }
        public void reverse(){
            Node prev = null;
            Node curr = tail = head;
            Node next;

            while (curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        public static void main(String[] args) {
            Reverse ll = new Reverse();
            ll.addLast(10);
            ll.addLast(20);
            ll.addLast(30);
            ll.addLast(40);
            ll.addLast(50);
            ll.addLast(60);
            ll.print();  
            System.out.println(ll.size);
            ll.reverse();
            ll.print();
        }
}
