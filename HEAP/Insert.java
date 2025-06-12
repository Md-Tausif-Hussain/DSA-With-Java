import java.util.*;

public class Insert {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){//O(log n)
            arr.add(data);//add at last index
            int x = arr.size()-1;//child index
            int par = (x-1)/2;//parent index

            while(arr.get(x) < arr.get(par)) {//O(log n)
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        public int peek(){
            return arr.get(0);
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(1);
        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        
        while (h != null){
            System.out.println(h.peek());//O(1)
            break;
            //h.remove();//O(logn)
        }
    }
}
