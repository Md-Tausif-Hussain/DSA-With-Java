import java.util.*;

public class LinearSearch{

//function to search an element
  public static int search(int array[], int s){
       int i;
     for( i = 0 ; i<array.length ; i++){
        if( array[i]== s);
        
  }
  return i;

}


    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
      System.out.print("Enter Size of an array : ");
      int n = sc.nextInt();

      int array[] = new int[n];

      for(int i = 0 ; i<array.length ; i++){
         System.out.print("Enter element "+i+" : ");
         array[i] =  sc.nextInt();

      }
       System.out.print("Enter value to search : ");
       int s = sc.nextInt();

      int  result = search(array,s);



     System.out.println("Element found at location : "+result);





    }
}