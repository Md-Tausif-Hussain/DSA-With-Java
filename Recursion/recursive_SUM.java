public class recursive_SUM {
     
 public static int Sum(int n){
  
    if(n == 1){
        return 1;
    }

    int sum1= Sum(n-1);

    int Sn = n + Sum(n-1);

    return Sn;

 //Time complexity = O(n)
 }



    public static void main(String[] args) {
        
     int n = 5;
     System.out.print(Sum(n));
    }
}
