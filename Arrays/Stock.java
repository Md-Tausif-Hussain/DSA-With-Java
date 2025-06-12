import java.util.*;

public class Stock {
    //timecomplexity = O(n)
    public static int BuyAndSellStock(int prices[]){
        int BuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i =0; i<prices.length; i++){
            if(BuyPrice < prices[i]){//profit
              int profit = prices[i] - BuyPrice;//today's profit
              maxProfit = Math.max(maxProfit,profit);
            }
            else{
                BuyPrice = prices[i];
            }
        }
        return maxProfit;
    }
public static void main(String[] args) {
    int prices[] = {7,1,5,3,6,4};
    System.out.println(BuyAndSellStock(prices));
}    
}
