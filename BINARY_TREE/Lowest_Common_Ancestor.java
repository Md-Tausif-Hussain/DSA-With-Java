import java.util.*;

    public class Lowest_Common_Ancestor {
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

    public static boolean getPath(Node root, int n , ArrayList<Node> Path){
        if(root == null){    
            return false;
          }
        Path.add(root);

        if(root.data == n){
            return true;
        }

        boolean FoundLeft  = getPath(root.left, n, Path);
        boolean FoundRight = getPath(root.right, n, Path);

        if(FoundLeft || FoundRight){
            return true;
        }

        Path.remove(Path.size()-1);
        return false;
    }

    public static Node LCA(Node root, int n1 , int n2){//TimeComplexity -> O(n)
        ArrayList<Node> Path1 = new ArrayList<>();
        ArrayList<Node> Path2 = new ArrayList<>();

        getPath(root,n1,Path1);
        getPath(root,n2,Path2);

        //Last Common Ancestor
        int i =0;
        for(;i<Path1.size() && i<Path2.size(); i++){
            if(Path1.get(i) != Path2.get(i)){
                break;
            }
        }

        //Last equal Node -> i-1th
        Node LCA = Path1.get(i-1);
        return LCA;
    }    

    public static Node LCA2(Node root , int n1, int n2){
     if(root == null || root.data == n1 || root.data == n2){
        return root;
     }
     Node leftLCA = LCA2(root.left,n1,n2);
     Node rightLCA = LCA2(root.right, n1, n2);

     if(rightLCA == null){
        return leftLCA;
     }
     if(leftLCA == null){
        return rightLCA;
     }
     return root;
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

        int n1=4, n2=5;
        System.out.println(LCA(root, n1, n2).data);
        System.out.println(LCA2(root, n1, n2).data);

        }
    }