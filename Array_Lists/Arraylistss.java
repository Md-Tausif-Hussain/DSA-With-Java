import java.util.*;
import java.util.ArrayList;

public class Arraylistss {
    public static void main(String[] args) {
        //ArrayList come under java collections framework ;

      ArrayList<Integer> list = new ArrayList<>();   

      //Add operation time complexity = O(1)
      list.add(1);
      list.add(3);
      list.add(5);
      list.add(7);
      list.add(9);
      System.out.println(list);
      System.out.println(list.size());


       //Get operation time complexity = O(1)
       int element = list.get(3);
       System.out.println(element);

       //Delete operation time complexity = O(n)
       list.remove(2);
       System.out.println(list);

       //Set operation  time complexity = O(n)
       list.set(2, 10);
       System.out.println(list);

      //Contains operation time complexity = O(n)
      System.out.println(list.contains(5));
      System.out.println(list.contains(10));
       
      //size() function
      System.out.println(list.size());
      for(int i = 0 ; i<list.size(); i++){
         System.out.print(list.get(i)+" ");
      }
         System.out.println();

         //reverse print
         System.out.print("REVERSE : ");
         for(int j = list.size()-1; j>= 0; j--){
            System.out.print(list.get(j)+" ");
         }
         System.out.println();

      //Maximum elements counts
      int max = Integer.MIN_VALUE;
      for(int k = list.size()-1; k>= 0; k--){
        //if(max < list.get(k)){
          //  max = list.get(k);
        //}
        max = Math.max(max, list.get(k)); // one line solution   
     }
     System.out.print("Maximum element : "+max);

    }
}
