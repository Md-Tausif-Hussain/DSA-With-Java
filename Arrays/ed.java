import java.util.Scanner;

public class ed {
    public static void main(String[] args){
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number :");
int n = sc.nextInt();


if(isEven(n)){
System.out.print("The enter number is EVEN .");
}

else{
System.out.print("The enter number is ODD .");
}


}

    
public static boolean isEven( int n){
if( n % 2 == 0){
    return true ;
}
else{
    return false ;
}

}


    
}
