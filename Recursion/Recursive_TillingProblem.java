public class Recursive_TillingProblem {
//Amazon_Question

    public static int tilling_Problem( int n){// 2 x n (floor_Size)
         
        //baseCase
        if(n == 0 || n == 1){
            return 1;
        }

        //Vertical_Choice
        int fnm1 = tilling_Problem(n-1);

        //horizonta_choice
        int fnm2 = tilling_Problem(n-2);

        int total_ways = fnm1 + fnm2;

        return total_ways;

    }

    public static void main(String[] args) {

        System.out.print(tilling_Problem(6));

    }
}
