public class Recursive_Fibonacci {
    
    public static int fibonacci(int n){
       if(n == 0 || n==1){
        return n;
       }
        int F1= fibonacci(n-1);
        int F2 = fibonacci(n-2);
         int Fn = F1 + F2;
         return Fn;

    }
    
    public static void main(String[] args) {
        int n = 4;
        System.out.print(fibonacci(n));
    }
}
