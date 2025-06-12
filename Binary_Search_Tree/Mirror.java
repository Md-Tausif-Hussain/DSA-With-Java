import java.util.*;

public class Mirror {
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
    public static Node createMirror(Node root){//TimeComplexity = O(n)
        if(root == null){                 
            return null;
        }
        Node leftMirror  = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void main(String[] args) {
        /*
         *             8
         *            / \
         *          5     10
         *        /  \      \
         *       3    6     11
         * 
        */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        root = createMirror(root);
        Pre_Order(root);
        /*  Result
         *             8
         *            / \
         *          10    5
         *         /     /  \
         *        11    3     6
         * 
        */
        
    }
}
