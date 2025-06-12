import java.util.*;

//butterfly pattern

public class pattern8 {
   
    public static void fly(int n){

    //1st half

    for(int i = 1 ; i<= n ; i++){
        //star for i ...
        for(int j = 1 ; j<= i ; j++)
        {
            System.out.print("*");
        }

        //spaces 2*(n-i)
        for(int j = i; j<= 2*(n-i); j++ ){
        System.out.print(" ");
        }
        
        for(int j = 1 ; j<= i ; j++)
        {
            System.out.print("*");
        }

    System.out.println();

    }



    //2nd half

    for(int i = n ; i>= 1 ; i--){
        //star for i ...
        for(int j = 1 ; j<= i ; j++)
        {
            System.out.print("*");
        }

        //spaces 2*(n-i)
        for(int j = i; j<= 2*(n-i); j++ ){
        System.out.print(" ");
        }
        
        for(int j = 1 ; j<= i ; j++)
        {
            System.out.print("*");
        }

    System.out.println();

    }

    }


    public static void main(String[] args) {
        
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of ROWS :");
int n = sc.nextInt();

fly(n);

    }

}
