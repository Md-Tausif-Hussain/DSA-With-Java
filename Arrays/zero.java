import java.util.*;

public class zero {
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a Number :");
    int n = sc.nextInt();
System.out.print("The sum is :"+sum(n));

}

public static int sum( int n){
int s = 0;
while( n != 0){
int lastDigit = n % 10 ;
s = s + lastDigit;
    n = n / 10 ;
}

return s ; 

}

}
