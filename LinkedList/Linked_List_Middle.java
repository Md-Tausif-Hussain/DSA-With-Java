import java.util.*;

public class Linked_List_Middle {
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
    public static int size;//global_variable

    public void print(){//print function
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

    public void add_middle(int idx , int data){//adding data in between the list
     Node newNode = new Node(data);
     size++;
     Node temp = head;
     int i = 0;
     while(i<idx-1){
        temp = temp.next;
        i++;
     }
     newNode.next = temp.next;
     temp.next = newNode;
    }  

    public void add_beginning(int data){//this function have TimeComplexity of O(1)
        //step 1 = create new node
        Node newNode = new Node(data);
        size++;
        if(head == null){
        head = tail = newNode ;
        return;
        }
        //step 2 -> connect to head
        newNode.next = head;//linking 
        //step 3 -> 
        head = newNode;
        }

        //Delete from 1st
        public int remove_first(){
            if(size == 0){
                System.out.println("LL is empty !");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
             int val = head.data;
             head = tail = null;
             size = 0;
             return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }

        public int remove_Last(){
            if(size == 0){
                System.out.println("LL is empty !");
                return Integer.MIN_VALUE;
            }
            else if(size == 1){
             int val = head.data;
             head = tail = null;
             size = 0;
             return val;
            }
            Node prev = head;
            for(int i = 0; i < size-2; i++){
                prev = prev.next;
            }
            int val = prev.next.data;//tail.data
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }

        public int search(int key){//key found
         Node temp = head;
         int i = 0;

         while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
         }
        //key not found
         return -1;
        }
    public static void main(String[] args) {
        Linked_List_Middle ll = new Linked_List_Middle();
        ll.add_beginning(10);
        ll.add_beginning(20);
        ll.add_beginning(30);
        ll.add_beginning(40);
        ll.add_beginning(50);
        ll.print(); 
        System.out.println("Size :"+ll.size);

        ll.add_middle(2,7);
        System.out.println();
        ll.print(); 
        System.out.println("Size :"+ll.size);

        ll.remove_first();
        ll.remove_first();
        System.out.println();
        ll.print(); 
        System.out.println("Size :"+ll.size); 

        System.out.println();
        ll.remove_Last();
        ll.print(); 
        System.out.println("Size :"+ll.size);

     System.out.println(ll.search(20));



    }
}
