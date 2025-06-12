import java.util.*;
import java.util.LinkedList;

//amazon Flipkart Qualcomm
public class DeleteFromEnd {
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
      public void deleteNthFromEnd(int n){
        
      //calculate_size
       int sz = 0; //size
       Node temp = head;
       while(temp!=null){
        temp = temp.next;
        sz++;
       }
       if(n== sz){
       head = head.next;//remove first operation
       return;
       }

       //sz-n
       int i = 1;
       int iToFind = sz -n;
       Node prev = head;
       while (i<iToFind) {
        prev = prev.next;
        i++; 
       }
       prev.next = prev.next.next;
       return;
       }
        public static void main(String[] args) {
        DeleteFromEnd ll = new DeleteFromEnd();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.print();  
        System.out.println(ll.size);
        System.out.println();

        ll.deleteNthFromEnd(3);
        ll.print();
        System.out.println(ll.size);


        }

}
