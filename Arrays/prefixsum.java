import java.util.*;


/*Time complexity of code is BigO of n^2 */

public class prefixsum{

    public static void printmaxsubArray(int n[]){
       
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[n.length];

        //calculate prefix Array
        prefix[0] = n[0];
        for(int i = 1 ; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + n[i];
        }

        for(int i = 0; i<n.length; i++){
            int start = i;
            for(int j = i; j<n.length; j++){
                int end = j;
                currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
               if(maxsum < currsum){
                maxsum  = currsum;
               }
            }
        }
        System.out.println("Max sum = "+maxsum);
       
    }

    public static void main(String[] args) {
        int n[]= {1,-2,6,-1,3};
        printmaxsubArray(n);
    }
}
