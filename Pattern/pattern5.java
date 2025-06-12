import java.util.*;

//right angle triangle "*"

public class pattern5 {
    
public static void pyramid( int n){
for(int i = 1; i<= n ; i++){
    for(int j = 1 ; j<= n-1; j++){
        System.out.print("");
    }
    for(int j = 1; j<=i ; j++){
        System.out.print("*");
    }
    System.out.println();
}
}

public static void main(String[] args) {
    
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of ROWS :");
int n = sc.nextInt();

pyramid(n);
}

}
