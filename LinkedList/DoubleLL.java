import java.util.LinkedList;
import java.util.*;

public class DoubleLL {
    public static class Node{//structure of the linked_list
        int data;
        Node next;
        Node prev;
        public Node (int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;//global_variable
    public static Node tail;//global_variable
    public static int size;

        //add 
       public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
       }

       //print
       public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("Null");
       }
    
       //remove -> removefirst
       public int remove(){
        if(head == null){
            System.out.println("Linked List is empty !");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

       }

       //Reverse the double linked list
       public void reverse(){
            Node prev = null;
            Node curr = head;
            Node next;

            while (curr != null){
                next = curr.next;
                curr.next = prev;
                curr.prev = next;

               prev = curr;
                curr = next;
            }
            head = prev;
       }
    
     public static void main(String[] args) {
    
        DoubleLL ll = new DoubleLL();

        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        System.out.println(ll.size);

        ll.remove();
        ll.print();
        System.out.println(ll.size);

        ll.reverse();
        ll.print();
        System.out.println(ll.size);


     }
}
