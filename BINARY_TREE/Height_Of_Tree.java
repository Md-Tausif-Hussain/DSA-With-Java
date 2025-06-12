import java.util.*;

public class Height_Of_Tree {
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
    
    //Fumction to calculate height
    public static int height(Node root){
        if(root == null){    
            return 0;
          }

          int lh = height(root.left);
          int rh = height(root.right);
          return Math.max(lh, rh)+ 1;
    }

    //Function to calculate Number Of Node
     public static int count(Node root){
        if(root == null){    
            return 0;  
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return (leftCount+rightCount+1);
     }
      //Function to calculate Sum of Nodes
     public static int sum(Node root){
        if(root == null){    
            return 0;  
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum+rightSum+root.data;
     }
    public static void main(String[] args) {
        /*
         *             1
         *            / \
         *          2     3
         *        /  \   /  \
         *       4    5  6   7
         * 
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height of tree: " + height(root)); // Output: 3
        System.out.println("Number of nodes: " + count(root)); // Output: 7
        System.out.println("Sum of all node values: " + sum(root)); // Output: 28
    }
}
