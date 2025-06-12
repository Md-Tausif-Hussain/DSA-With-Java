import java.util.*;
//Time Complexity = O(n)
public class PreOrderTraversal {
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
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

    public static void In_Order(Node root){//In-Order Traversal                                   
        if(root == null){                  // left - root - right
            return;
          }
          In_Order(root.left);
          System.out.print(root.data+" ");
          In_Order(root.right);
    }

    public static void Post_Order(Node root){//Post Order Traversal
        if(root == null){                    //left - right - root
            return ;
          }
          Post_Order(root.left);
          Post_Order(root.right);
          System.out.print(root.data+" ");
          
    }

    //Level Order Traversal -> Breadth First Search
    public static void Level_Order(Node root){
        if(root == null){                    
            return;
          }

          Queue<Node> q = new LinkedList<>();
          q.add(root);
          q.add(null);

          while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
          }
    }
    public static void main(String[] args) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root =  tree.buildTree(nodes);
        System.out.println(root.data);
       
        System.out.println("Pre Order : ");
        Pre_Order(root);
        System.out.println();
        System.out.println();
        System.out.println("In Order : ");
        In_Order(root);
        System.out.println();
        System.out.println();
        System.out.println("Post Order : ");
        Post_Order(root);
        System.out.println();
        System.out.println();
        System.out.println("Level Order : ");
        Level_Order(root);
        
    }
}
