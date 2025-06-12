import java.util.*;

public class CatalanNumbers{
    public static int catalanRec(int n){//Recursive way
      if(n==0 || n==1){
        return 1;
      }

      int ans =0; //cn
      for(int i=0; i<=n-1; i++){
        ans += catalanRec(i) * catalanRec(n-i-1);
      }
      return ans;
    }

    public static int catalanRec_Memoization(int n, int dp[]){//Memoization way
        if(n==0 || n==1){
          return 1;
        }
  
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += catalanRec_Memoization(i, dp) * catalanRec_Memoization(n-i-1, dp);
        }

        return dp[n] = ans;
      }

      public static int catalanTAB(int n){//Tabulation way
        int dp[] = new int[n+1];
        dp[0] =1;
        dp[1] = 1;

        for(int i=2; i<=n ; i++){
           for(int j=0; j<i; j++){
               dp[i] += dp[j] * dp[i-j-1] ;
           }
        }
        return dp[n];
      }

    public static void main(String[] args) {
        int n =4;
        System.out.println(catalanRec(n));

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(catalanRec_Memoization(n, dp));

        System.out.println(catalanTAB(n));
    }
}
