import java.util.*;

public class MatrixChainMultiplication {

    public static int MCM(int arr[] , int i , int j){//Recursive Way
       if(i==j){
        return 0;//single matrix case
       }
       int ans = Integer.MAX_VALUE;
       for(int k=i; k<=j-1; k++){
        int cost1 = MCM(arr,i,k);
        int cost2 = MCM(arr, k+1, j);
        int cost3 = arr[i-1] * arr[k] * arr[j];
        int finalCost = cost1+cost2+cost3;
        ans = Math.min(ans, finalCost);
       }
       return ans;//minCost
    }

    public static int MCM_memo(int arr[] , int i , int j,int dp[][]){//Memoization Way
        if(i==j){
            return 0;//single matrix case
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
       for(int k=i; k<=j-1; k++){
        int cost1 = MCM_memo(arr,i,k,dp);
        int cost2 = MCM_memo(arr, k+1, j,dp);
        int cost3 = arr[i-1] * arr[k] * arr[j];
        int finalCost = cost1+cost2+cost3;
        ans = Math.min(ans, finalCost);
       }
       return dp[i][j] = ans;//minCost
    }
    
    public static int mcmTAB(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //initialization
        for(int i=0; i<n;i++){
            dp[i][i] = 0;
        }

        //Bottom_UP
        for(int len =2 ; len<= n-1; len++){
            for(int i=1; i<=n-len;i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];
                    int finalCost = cost1+cost2+cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                   }

            }
        }
       return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;

        System.out.println(MCM(arr, 1, n-1));

        int dp[][] = new int[n][n];
        for(int i=0; i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(MCM_memo(arr, 1, n-1,dp));

        System.out.println(mcmTAB(arr));

    }
}
