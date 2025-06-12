import java.util.Scanner;
import java.util.*;



public class matrix {
    
  public static boolean search( int matrixs[][],int key){
    
    
    for(int i = 0 ; i < matrixs.length ; i++){
        for(int j = 0; j<matrixs[0].length; j++){
            if(matrixs[i][j] == key){
                System.out.println("Key found at location Row No."+i+" coloumn no."+j);
                return true;
            }

        }
    }
System.out.println("Key not found at location.");
                return false;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     
    //Row
    System.out.print("Enter row for matrix : ");
    int r = sc.nextInt();
     
    //column
    System.out.print("Enter coloumn for matrix : ");
    int c = sc.nextInt();

    int matrixs[][] = new int[r][c];
    System.out.println();
    int h = r*c;
System.out.print("Enter " +h+ " element into the matrix : ");
    for(int i = 0 ; i < r ; i++){
        for(int j = 0; j<c; j++){
            matrixs[i][j] = sc.nextInt();
        }
    }

    for(int i = 0 ; i < r ; i++){
        for(int j = 0; j<c; j++){
            System.out.print(matrixs[i][j]+" ");
        }
        System.out.println();
    }

    System.out.println("Enter value to searched : ");
    int key = sc.nextInt();
     search(matrixs , key);
  }

}
