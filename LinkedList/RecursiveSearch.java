import java.util.*;
import java.util.LinkedList;

public class RecursiveSearch {
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

        public static int helper(Node head, int key){
          if(head == null){
            return -1;
          }
          if(head.data == key){
            return 0;
          }
          int idx = helper(head.next, key);
          if(idx == -1){
            return -1;
          }
          return idx+1;
        }
    
    public static int recursive_Search(int key){
      return helper(head,key);
    }

    public static void main(String[] args) {
           RecursiveSearch ll = new RecursiveSearch();
        
        ll.add_beginning(10);
        ll.add_beginning(20);
        ll.add_beginning(30);
        ll.add_beginning(40);
        ll.add_beginning(50);
        ll.print();  
        System.out.println(ll.size);

        System.out.println(ll.recursive_Search(30));
    }
}
