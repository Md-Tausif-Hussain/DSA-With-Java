public class Recursive_Friend_Pairing {
    //Goldman Sachs Questions

    public static int friendsPairing(int n){
         
        if( n == 1 || n == 2){
            return n;
        }
        

         //single
        int fnm1 = friendsPairing(n-1);
        
        //pair
        int fnm2 = friendsPairing(n-2);
        int pairways = (n-1)*fnm2;

        //total no. of ways
        int total_ways = fnm1 + pairways;

        return total_ways;
    }

    public static void main(String[] args) {
        System.out.print(friendsPairing(3));
    }
}
