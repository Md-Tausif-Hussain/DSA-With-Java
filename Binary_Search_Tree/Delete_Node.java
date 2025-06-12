import java.util.*;

public class Delete_Node {
    // In BST TimeComplexity = O(h)
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
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

    public static void inOrder(Node root){ // In-Order Traversal                                   
        if(root == null){                  // left - root - right
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
     
    public static Node delete(Node root, int val){
        if (root == null) {
            return null; // Node to be deleted not found
        }

        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else { // Node to be deleted found
            // Case-1 -> Leaf Node
            if(root.left == null && root.right == null){
                return null;
            }
            // Case-2 -> Single Child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            // Case-3 -> Both Children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for(int value : values){
            root = insert(root, value);
        }
        inOrder(root);
        System.out.println();

        root = delete(root, 10); // Attempting to delete a non-existing node
        inOrder(root);
        System.out.println();

        root = delete(root, 3); // Deleting an existing node
        inOrder(root);
    }
}
