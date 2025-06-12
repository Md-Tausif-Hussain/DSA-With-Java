import java.util.*;

public class Sliding_Window_Maximum {
    static class Pair implements Comparable<Pair>{
        int value;
        int index;
  
        public Pair(int value, int index){
          this.value = value;
          this.index = index;  
        }
        @Override
        public int compareTo(Pair p2){
          return p2.value - this.value;
        }
      }
    public static void main(String[] args) {//O(nlog k)
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k =3;//window size
        int res[] = new int[arr.length-k+1];//n-k+1

        PriorityQueue<Pair> p = new PriorityQueue<>();

        //1st Window
        for(int i =0; i<k; i++){
            p.add(new Pair(arr[i], i));
        }
        res[0] = p.peek().value;

        for(int i =k; i <arr.length; i++){
            while (p.size() > 0 && p.peek().index <= (i-k)){
                p.remove();
            }
            p.add(new Pair(arr[i],i));
            res[i-k+1] = p.peek().value;
        }

        for(int i =0; i<res.length; i++){
           System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
