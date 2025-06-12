import java.util.*;
//time complexity is equal to O(nlogn)
public class QuickSort_C {
   public static void Quick_sort(int a[], int first , int last){
        int i,j,pivot,temp;
        if(first < last){
        pivot = first;
        i = first;
        j = last;
        while(i<j){
            while( a[i]<=a[pivot] && i<last){
                i++;
            }
            while(a[j] > a[pivot]){
                j--;
            }
            if(i<j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp ;
            }
        }
        temp = a[pivot];
        a[pivot] = a[j];
        a[j]  = temp;
        Quick_sort(a,0,j-1);
        Quick_sort(a,j+1,last);
      }
    }
    public static void print(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
          }
    }
public static void main(String[] args) {
    int a[]= {8,5,7,9,6,4,5,3,1};
    Quick_sort(a,0,a.length-1);
    print(a);
}    
}
