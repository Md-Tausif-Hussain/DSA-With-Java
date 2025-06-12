import java.util.*;
public class Sorting_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();   
      //Add operation time complexity = O(1)
      list.add(1);
      list.add(7);
      list.add(3);
      list.add(5);
      list.add(2);
      System.out.println(list);

      Collections.sort(list);//Ascending Order
      System.out.println(list);
      
      Collections.sort(list,Collections.reverseOrder());//Decending Order 
      System.out.println(list);
    }
}
