import java.util.*;



public class Diameter_Of_A_Tree {
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

    public static int Diameter(Node root){//TimeComplexity = O(n^2)
        if(root == null){    
            return 0;
          }

          int leftDiameter = Diameter(root.left);
          int leftHeight = height(root.left);
          int rightDiameter = Diameter(root.right);
          int rightHeight = height(root.right);

          int selfDiameter = leftHeight + rightHeight + 1;

          return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root){//TimeComplexity = O(n)
        if(root == null){    
            return new Info(0, 0);
          }

        Info leftInfo = diameter(root.left);
        Info righInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam,righInfo.diam),leftInfo.ht+righInfo.ht+1);
        int ht = Math.max(leftInfo.ht,righInfo.ht)+1;

        return new Info(diam, ht);
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

        System.out.println(Diameter(root));
        System.out.println(diameter(root).diam);

    }
}
