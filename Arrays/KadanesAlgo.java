import java.util.*;
/*Time complexity of this code id BigO of 'n'. */

public class KadanesAlgo {

   public static void maxSubArray(int n[]){
           

    int maximum_sum = Integer.MIN_VALUE;
    int current_sum = 0;

    for(int i =0; i<n.length; i++){

         current_sum += n[i];
         if( current_sum < 0){
            current_sum = 0;
         }

         maximum_sum = Math.max(current_sum,maximum_sum);

    }

    System.out.print("Our Maximum sub array sum is : "+maximum_sum);
   }

    public static void main(String[] args) {
        int n[] = {-2,-3,4,-1,-2,1,5,-3};
        maxSubArray(n);
    }
    
}
