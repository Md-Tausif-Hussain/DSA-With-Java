import java.util.*;

public class factorial{

public static int fact(int n){//Factorial Code
int f = 1;
for(int i = 1; i<=n; i++){
    f=f*i;
}
return f;
}

public static int Binomial_Coefficent(int N,int r ){
//Binomial_Coefficient         
int a = fact(N);                
    int  R = fact(r);
    int  c = fact(N-r);

     int D = a/(R*c);
     

     return D;
}
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter N : ");
    int n = sc.nextInt();

    System.out.print("Enter R : ");
    int r = sc.nextInt();


    int W = Binomial_Coefficent(n,r);
  System.out.println(W);


}

}