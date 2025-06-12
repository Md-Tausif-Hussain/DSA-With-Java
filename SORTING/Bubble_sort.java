import java.util.*;
/* time complexity O(n^2)*/ 
public class Bubble_sort {
    public static void BubbleSort(int arr[]){
        for(int turn=0; turn<arr.length-1; turn++){
            for(int j = 0; j < arr.length-1-turn; j++ ){
                if(arr[j]> arr[j+1]){
                    int temp = arr[j];
                       arr[j] = arr[j+1];
                       arr[j+1] = temp;
                }
            }
        }
    }
    public static void print(int arr[]){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
          }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,8,7,49,1,25,76};
        BubbleSort(arr);
        print(arr);
    }
}
