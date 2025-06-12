import java.util.*;
import java.util.LinkedList;

public class Palindrome {
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

    //slow fast approach
    public Node findMid(Node head){
     Node slow = head ;
     Node fast = head;

     while(fast != null && fast.next == null){
        slow = slow.next;//+1
        fast = fast.next.next;//+2
     }
     return slow ; //slow is my midNode
    }

    public boolean checkPalindrome(){
        //BaseCase
        if(head == null || head.next != null){
            return true;
        }

        //Step 1 -> find Mid
        Node midNode = findMid(head);

        //Step 2 -> reverse 2nd half 
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev ;//rigth half head
        Node left =  head;

        //step 3 -> check left half & right half 
        //check if equal
        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    public static void main(String[] args) {
        Palindrome ll = new Palindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();  
        System.out.println(ll.size);

        System.out.println(ll.checkPalindrome());
    }
}
