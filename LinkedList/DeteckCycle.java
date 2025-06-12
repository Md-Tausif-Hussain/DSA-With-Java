import java.util.*;
import java.util.LinkedList;


public class DeteckCycle {
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

         public static boolean isCycle(){//The Floyd Cycle-Finding Algorithm
         Node slow = head ;
         Node fast = head;

         while(fast != null && fast.next != null){
         slow = slow.next;//+1
         fast = fast.next.next;//+2
         if(slow == fast){
            return true; //Cycle Exists
         }
         }
         return false;//Cycle doesn"t exists
         }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        //head.next.next.next = head;
        System.out.println(isCycle());
        
    }
}
