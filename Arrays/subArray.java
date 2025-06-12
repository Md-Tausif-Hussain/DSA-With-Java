import java.util.*;


public class subArray {
    public static void printArray(int n[]){

        int total = 0;
        for(int i = 0; i<n.length; i++){
            int start = i;
            for(int j = i; j<n.length; j++){
                int end = j;
                for(int k = start; k<= end; k++){
                    System.out.print(n[k]+" ");
                }
                total++;
                System.out.println();
            }

            System.out.println();
        }

        System.out.println("Total Subarrays = "+total++);
    }

    public static void main(String[] args) {
        int n[]= {2,4,6,8,10};
        printArray(n);
    }
}
