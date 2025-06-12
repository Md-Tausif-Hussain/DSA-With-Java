import java.util.*;
import java.util.ArrayList;

public class Convert_To_BalancedBST {
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

    public static void Pre_Order(Node root){//Pre-Order Traversal
        // root - left - right
    if(root == null){
    return;
    }
    System.out.print(root.data+" ");
    Pre_Order(root.left);
    Pre_Order(root.right);
    }
    
    public static Node Create_BST(ArrayList<Integer>inorder, int st , int end){
        if(st > end){
         return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = Create_BST(inorder, st,mid-1);
        root.right = Create_BST(inorder,mid+1, end);
        return root;
        }
    
    
    public static void getInorder(Node root , ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);

    }
    public static Node balanceBST(Node root){
        //Inorder Sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted Inorder Balanced BST
        root = Create_BST(inorder, 0, inorder.size()-1);
        return root;

    }

    public static void main(String[] args) {
        /*
         *       
         *             8      
         *            / \
         *           6    5
         *         /       \
         *        5         10
         *       /            \
         *      3             12
        */
         
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right= new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balanceBST(root);
        Pre_Order(root);
        /*  Result 
         *             8
         *            / \
         *          5     11
         *        /  \   /  \
         *       3    6 10   12
        */
        
    }
}
