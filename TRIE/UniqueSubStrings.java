import java.util.*;

public class UniqueSubStrings {
    static class Node {
        Node[] children; // Correct type for children
        boolean eow; // End of word flag

        Node() {
            children = new Node[26]; // Initialize the array with size 26
            eow = false; // Initialize the end of word flag as false
        }
    }
    public static Node root = new Node(); // Initialize the root of the trie
    // Method to insert a word into the trie
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // Calculate the index
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(); // Create a new node if it does not exist
            }
            curr = curr.children[idx]; // Move to the next node
        }
        curr.eow = true; // Mark the end of the word
    }
    public static boolean Search(String key) { // O(n)
        Node curr = root;
        key = key.toLowerCase(); // Convert the key to lowercase to handle case sensitivity
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a'; // Calculate the index
            if (curr.children[idx] == null) {
                return false; // If the node does not exist, return false
            }
            curr = curr.children[idx]; // Move to the next node
        }
        return curr.eow; // Return true if it's the end of the word
    }

    public static int CountNodes(Node root){
      if(root == null){
        return 0;
      }
      int count =0;
      for(int i=0; i<26; i++){
        if(root.children[i] != null){
            count += CountNodes(root.children[i]);
        }
      }
      return count+1;
    }

    public static void main(String[] args) {
        String s = "apple";
        for(int i=0; i<s.length();i++){
            String suffix = s.substring(i);
            insert(suffix);
        }

        System.out.println(CountNodes(root));
    }
}
