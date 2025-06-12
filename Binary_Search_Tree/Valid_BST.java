import org.w3c.dom.Node;

public class Valid_BST {
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

    public static boolean isValidBST(Node root, Node min, Node max ){
        if(root == null){                 
            return true ; 
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        else if(max != null && root.data <= min.data){
          return false;
        }

        return isValidBST(root.left, min, max) && isValidBST(root.right, min, max);
    }
    public static void main(String[] args) {
         int values[] = {5,1,3,4,2,7};
    Node root = null;
         for(int i =0; i<values.length;i++){
            root = insert(root, values[i]);
         }
         In_Order(root);
         System.out.println();

         if(isValidBST(root, null, null)){
            System.out.print("Valid");
         }
         else{
            System.out.print("Not Valid !");
         }
    }
}
