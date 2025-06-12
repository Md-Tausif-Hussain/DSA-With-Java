import java.util.*;

public class RemoveCycle {
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

         public static void Remove_Cycle(){
            //detect cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                 cycle = true;
                 break;
                }
            }
            if(cycle == false){
                return ;
            }

            //find meeting point
            slow = head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }

            //remove cycle -> last.next = null
            prev.next = null;

         }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(isCycle());
        Remove_Cycle();
        System.out.println(isCycle());
        
        
        
    }
}
