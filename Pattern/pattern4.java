import java.util.*;

// Hollow rectangle 

public class pattern4{

    public static void hollow_rectangle(int ROWS , int coloums){

        for(int i = 1 ; i<= ROWS ; i++){
            for(int j = 1; j<= coloums ; j++){
                if(i == 1 || i == ROWS || j == 1 || j == coloums){
                   System.out.print("*");
                }
                else{
                 System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

public static void main(String[] args) {
    

Scanner sc = new Scanner(System.in);
System.out.print("Enter number of ROWS :");
int ROWS = sc.nextInt();
System.out.print("Enter number of COLOUMS :");
int coloums = sc.nextInt();

hollow_rectangle(ROWS, coloums);

}

}