import java.util.*;

public class Print_In_Range {
    // In BST TimeComplexity = O(h)
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            // this.left = null;
            // this.right = null;
        }
    }

    public static Node insert(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(root.data > value){
            root.left = insert(root.left, value);
        }
        else{
            root.right = insert(root.right, value);
        }

        return root;
}
    public static void In_Order(Node root){//In-Order Traversal                                   
     
    if(root == null){                  // left - root - right
        return;
    }
      In_Order(root.left);
      System.out.print(root.data+" ");
      In_Order(root.right);
    } 

    public static void PrintInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data >= k1 && root.data<= k2){
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            PrintInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
          PrintInRange(root.left, k1, k2);
        }
        else{
            PrintInRange(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
         for(int i =0; i<values.length;i++){
            root = insert(root, values[i]);
         }
         In_Order(root);
         System.out.println();
         PrintInRange(root, 5, 12);
    }
}
