public class BST {
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
        public static boolean search(Node root , int key){
            if(root == null){
                return false;
            }
            if(root.data == key){
                return true;
            }
            if(root.data > key){
                return search(root.left, key);
            }
            else{
                return search(root.right, key);
            }
        }
    public static void main(String[] args) {
    int values[] = {5,1,3,4,2,7};
    Node root = null;
         for(int i =0; i<values.length;i++){
            root = insert(root, values[i]);
         }
         In_Order(root);
         System.out.println();
         int key = 1;
         if(search(root,key)){
            System.out.println(key +" Found ");
         }else{
            System.out.println("Not Found");
         }
    }  
}
