import java.util.ArrayList;
import java.util.List;

public class Merge_Two_BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Pre-Order Traversal (root - left - right)
    public static void Pre_Order(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Pre_Order(root.left);
        Pre_Order(root.right);
    }

    // Inorder Traversal to collect elements in sorted order
    public static void getInorder(Node root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    // Function to merge two sorted lists into one sorted list
    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }
        return mergedList;
    }

    // Build a balanced BST from a sorted list
    public static Node Create_BST(List<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = Create_BST(inorder, st, mid - 1);
        root.right = Create_BST(inorder, mid + 1, end);
        return root;
    }

    // Merge two BSTs into a new BST
    public static Node mergeBST(Node root1, Node root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Perform inorder traversal to get sorted lists
        getInorder(root1, list1);
        getInorder(root2, list2);

        // Merge sorted lists
        List<Integer> mergedList = mergeSortedLists(list1, list2);

        // Build a balanced BST from the merged sorted list
        return Create_BST(mergedList, 0, mergedList.size() - 1);
    }

    public static void main(String[] args) {
        /*
         *          2
         *         / \  
         *        1   4   
         * 
         *       BST - 1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
         *          9
         *         / \  
         *        3   12   
         * 
         *       BST - 2
         */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        // Merge BSTs
        Node mergedRoot = mergeBST(root1, root2);

        // Print pre-order traversal of merged BST
        System.out.print("Pre-order traversal of merged BST: ");
        Pre_Order(mergedRoot);
    }
}
