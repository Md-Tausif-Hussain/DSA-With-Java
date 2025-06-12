import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins,Comparator.reverseOrder());

        int CountOfCoins = 0;
        int amount = 362;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i =0; i <coins.length; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    CountOfCoins++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }
        System.out.println("Total Minimum coins used = "+CountOfCoins);

        for(int i =0; i<ans.size(); i++){
            System.out.println(ans.get(i)+" ");
        }
        System.out.println();
    }
}
