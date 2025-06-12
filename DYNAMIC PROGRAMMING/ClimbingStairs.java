import java.util.*;

public class ClimbingStairs {
    public static int countWays(int n){//Recursive Way -> O(2^n)
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return countWays(n-1)+countWays(n-2);
    }
    
    public static int CountWay(int n, int ways[]){//Memoization Way -> O(n)
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){
            return ways[n];
        }
        ways[n] = CountWay(n-1,ways)+CountWay(n-2,ways);
        return ways[n];
    }

    public static int CountWayTabulation(int n){//Tabulation way -> O(n)
      int dp[] = new int[n+1];
      dp[0] = 1;
      //tabulation loop
      for(int i=1; i<=n; i++){
        if(i==1){
            dp[i] = dp[i-1] +0;
        }
        else{
            dp[i] = dp[i-1] + dp[i-2];
        }
      }
      return dp[n];
    }


    public static void main(String[] args) {
        int n=5;
        System.out.println("Recursiver Way : "+countWays(n));
        int ways[] = new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println("Memoization Way : "+CountWay(n, ways));
        System.out.println("Tabulation way : "+CountWayTabulation(n));
    }
}
