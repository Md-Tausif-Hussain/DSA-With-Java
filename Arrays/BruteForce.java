import java.util.*;
/*Time complexity of this brute force code is BigO of n^3 
  which is very slow */
public class BruteForce {

    public static void printmaxsubArray(int n[]){
       // int total = 0;
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;


        for(int i = 0; i<n.length; i++){
            int start = i;
            for(int j = i; j<n.length; j++){
                int end = j;
                currsum = 0;
                for(int k = start; k<= end; k++){
                    //System.out.print(n[k]+" ");
                    currsum += n[k]; 
                }
                System.out.print(currsum);
               // total++;
               if(maxsum < currsum){
                maxsum  = currsum;
               }
               System.out.println();
            }

            System.out.println();
        }
        System.out.println("Max sum = "+maxsum);
       // System.out.println("Total Subarrays = "+total++);
    }

    public static void main(String[] args) {
        int n[]= {1,-2,6,-1,3};
        printmaxsubArray(n);
    }
}
