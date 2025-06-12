import java.util.*;

public class PrefixProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i=0; i<children.length;i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node(); 
    // Method to insert a word into the trie
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // Calculate the index
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(); // Create a new node if it does not exist
            }else{
              curr.children[idx].freq++; // Move to the next node
            }

           curr = curr.children[idx];
        }
        curr.eow = true; // Mark the end of the word
    }

    public static void findPrefix(Node root, String ans){//O(L) longest words
          if(root == null){
            return ;
          }

          if(root.freq == 1){
            System.out.println(ans);
            return;
          }
          for(int i=0; i<root.children.length;i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
          }
    }

    public static void main(String[] args){
        String arr[] = {"zebra","dog","duck","dove"};

        for(int i=0; i<arr.length;i++){
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
        
    }
}
