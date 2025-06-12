import java.util.*;
//LeetCode -> 733
public class FloodFillAlgorithm{

    public void Helper(int[][]image, int sr, int sc, int colour,boolean vis[][], int orgColour){
         if(sr<0 || sc<0 || sr>=image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColour ){
            return;
         }
         //left
         Helper(image, sr, sc-1,colour,vis, orgColour);
         //right
         Helper(image, sr, sc+1, colour, vis, orgColour);
         //UP
         Helper(image, sr-1, sc, colour, vis, orgColour);
         //down
         Helper(image, sr+1, sc, colour, vis, orgColour);
    }

    public int[][] FloodFill(int [][] image, int sr, int sc, int colour){
        boolean vis[][] = new boolean[image.length][image[0].length];
        Helper(image, sr, sc, colour, vis,image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        
    }
}
