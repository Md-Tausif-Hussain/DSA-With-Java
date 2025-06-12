import java.util.LinkedList;
import java.util.*;

public class LinkedList_First{
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
    public static void main(String[] args) {
        LinkedList_First ll = new LinkedList_First();
        ll.print();
        ll.add_beginning(10);
        ll.add_beginning(20);
        ll.add_beginning(30);
        ll.add_beginning(40);
        ll.add_beginning(50);
        
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addLast(60);
        ll.print();  
        System.out.println(ll.size);
    }
}
