public class RecursionFactorial{
      public static int fact(int n){
        if(n == 0){
            return 1;
        //Time Complexity = 1;
        }
        int f = n*fact(n-1);
        return f;
      }
    public static void main(String args[]){
        int n = 5 ;
       System.out.print(fact(n));
    }
}
