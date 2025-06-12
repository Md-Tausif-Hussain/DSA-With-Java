import java.util.*;
public class palinrome {  
    public static boolean palin(int number){
        int n = number;
        int reverse = 0;
        while(n != 0){
        int remainder = n % 10;
        reverse = (reverse*10) + remainder;
        n = n / 10;
        }
        if( number == reverse){
        return true ;
        }
        else{
            return false ;
        }
        }
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter a Number :");
int n = sc.nextInt();
if(palin(n)){
    System.out.print("Number : "+n+" is a palindrome");
}
else{
System.out.print("Number : "+n+" is not a palindrome");
}
}
}
