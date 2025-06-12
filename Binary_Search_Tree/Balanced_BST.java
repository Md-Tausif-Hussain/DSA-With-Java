import java.util.*;

public class Balanced_BST {
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

    public static Node Create_BST(int arr[], int st , int end){
    if(st > end){
     return null;
    }
    int mid = (st+end)/2;
    Node root = new Node(arr[mid]);
    root.left = Create_BST(arr, st,mid-1);
    root.right = Create_BST(arr,mid+1, end);
    return root;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,6,8,10,11,12};
    /*
         *             8
         *            / \
         *          5     11
         *        /  \   /  \
         *       3    6 10   12
         * 
         * Expected Output
         * 
        */
        Node root = Create_BST(arr, 0, arr.length-1);
        Pre_Order(root);
    }
}
