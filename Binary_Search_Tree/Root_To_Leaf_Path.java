import java.util.*;
import java.util.ArrayList;

public class Root_To_Leaf_Path {
    // In BST TimeComplexity = O(h)
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
             this.right = null;
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
    public static void printPath(ArrayList<Integer> path){
        for(int i =0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printRoot_to_Leaf(Node root , ArrayList<Integer> path){
       if(root == null){
        return;
       }

       path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot_to_Leaf(root.left, path);
        printRoot_to_Leaf(root.right, path);
        path.remove(path.size()-1);
       }
    
    public static void main(String[] args){
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i =0; i<values.length;i++){
            root = insert(root, values[i]);
        }

        In_Order(root);
        System.out.println();

        printRoot_to_Leaf(root, new ArrayList<>());
        
    }
}
