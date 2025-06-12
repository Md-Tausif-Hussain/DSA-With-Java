import java.util.*;

//alphabetic triangle

public class pattern3 {
public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of ROWS :");
    int n = sc.nextInt();
    
    char ch = 'A';

        for(int i = 1 ; i<= n ; i++){
        for(int j = 1 ; j<= i; j++){
        System.out.print(ch);
        ch++;
            }
            System.out.println();
        }

}    
}
