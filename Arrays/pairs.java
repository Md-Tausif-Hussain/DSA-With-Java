import java.util.*;

public class pairs{

public static void pair(int n[]){
  int total= 0,  i;
  for( i= 0; i<n.length; i++){
   int current = n[i];
   for(int j = i+1; j<n.length; j++){
      System.out.print("("+current + ","+ n[j]+")");
      total++;
   }
   System.out.println();
  }

}

 public static void main(string args[])
 {
int n[] ={2,4,6,8};
   pair(n);
 }
}

