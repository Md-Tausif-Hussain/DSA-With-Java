
import java.util.*;

public class Heap_Sort{
    
    public static void heapify(int arr[],int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int midIdx = i;

        if(left <size && arr[midIdx] > arr[left]){
            midIdx = left;
        }
        if(right <size  && arr[midIdx] > arr[right]){
         midIdx = right;
        }
        if(midIdx != i){
            int temp = arr[i];
            arr[i] = arr[midIdx];
            arr[midIdx] = temp;

            heapify(arr, midIdx, size);
        }
    }

    public static void heapsort(int arr[]){
        //step -1 build maxHeap
     int n = arr.length;
     for(int i = n/2; i>= 0; i--){
        heapify(arr,i,n);
     }

     //step - 2 push largest at end
     for(int i = n-1; i>0; i--){
        //swap largest first with last
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
     heapify(arr,0,i);
     }
    }

    public static void main(String[] args){
        int arr[] = {1,2,4,5,3};
        heapsort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+" ");
        }
    }
}
