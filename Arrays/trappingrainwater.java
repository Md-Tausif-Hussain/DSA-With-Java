import java.util.*;

/**
 Timecomplexity of this program is O(n)...which is best timecomplexity!
 */
public class trappingrainwater {

       public static int trapping(int height[]){
            int n = height.length;
        //calculate left max boundary
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for(int i = 1; i< n; i++){

            leftmax[i] = Math.max(height[i], leftmax[i-1]);
        }
      //calulate rightmax boundary 
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
          for(int i = n-2; i >= 0 ; i--){
            rightmax[i] = Math.max(height[i], rightmax[i+1]);
          }

          int trapped_water = 0;
          
          //loop
          for(int i = 0; i< n ; i++){
          int  water_level = Math.min(leftmax[i], rightmax[i]);
             trapped_water += water_level - height[i];
          }


          return trapped_water;
       }


    public static void main(String[] args) {
        
       int height[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};

       System.out.println(trapping(height));

    }
}