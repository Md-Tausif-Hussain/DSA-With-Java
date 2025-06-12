import java.util.*;

public class Pair_Sum {
    //Brute Force approach
    //timecomplexity = O(n^2)
    public static boolean pairsum1(ArrayList<Integer> list , int target){
     
        for( int i =0; i<list.size(); i++){
            for(int j = i+1 ; j<list.size(); j++){
                if(list.get(i)+ list.get(j) == target){
                   return true;
                }
            }
        }

        return false;
    }

    //two pointer approach
    //timecomplexity = O(n^2)
    public static boolean pair_sum1(ArrayList<Integer> list , int target){
      int lp =0; //left_pointer
      int rp = list.size()-1; //right_pointer
      while(lp != rp) {
        //case-1
        if(list.get(lp)+list.get(rp) == target){
            return true;
        }

        //case-2
        if(list.get(lp)+list.get(rp) < target){
            lp++;
        }
        //case-3
        else{
            rp--;
        }
      }
      return false;
    }

    //for sorted & rotated array
    public static boolean pair_sum2(ArrayList<Integer> list , int target){
        int bp =-1;
        int n = list.size();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){//breaking point
                bp = 1;
                break;
            }
        }

        int lp = bp+1;//smallest element
        int rp = bp; //largest element

        while (lp!=rp){
              //case-1
                if(list.get(lp)+list.get(rp) == target){
                  return true;
                 }

              //case-2
             if(list.get(lp)+list.get(rp) < target){
               lp = (lp+1)%n;
             }
             //case-3
              else{
               rp = (n+rp-1)%n;
              }
        }
        return false;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //sorted 1 2 3 4 5 6
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        int target1 = 5;
        
        //Rotated & sorted array
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        int target2 =16;

        System.out.println(pairsum1(list1, target1));
        System.out.println();
        System.out.println(pair_sum1(list1, target1));

        System.out.println();
        System.out.println(pair_sum2(list2, target2));

    }
}
