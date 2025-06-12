import java.util.*;

public class Delete_In_Heap{

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

                x = par;
                par = (x-1)/2;
            }
        }
    

    public int peek(){
        return arr.get(0);
    }

    private void heapify(int i){
        int left = 2*i+1;
        int right = 2*i+2;
        int midIdx = i;

        if(left < arr.size() && arr.get(midIdx) > arr.get(left)){
            midIdx = left;
        }
        if(right < arr.size() && arr.get(midIdx) > arr.get(right)){
         midIdx = right;
        }
        if(midIdx != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(midIdx));
            arr.set(midIdx, temp);
        }
    }
    public int remove(){
    int data = arr.get(0);
    //Step - 1
    int temp = arr.get(0);
    arr.set(0,arr.get(arr.size()-1));
    arr.set(arr.size()-1, temp);
    //Step - 2
    arr.remove(arr.size()-1);
    //Step - 3
    heapify(0);
    return data;
    }

    public boolean isEmpty(){
        return arr.size() == 0;
    }
}
    public static void main(String[] args) {
        Heap h = new Heap();

        
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        
        while (!h.isEmpty()){
            System.out.println(h.peek());//O(1)
            h.remove();//O(logn)
        }
    }
}
