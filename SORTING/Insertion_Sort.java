import java.util.*;
public class Insertion_Sort {
   public static void insertion_sort(int a[]){
        int i,j,temp;
        for(i = 0; i<a.length ; i++){
            temp = a[i];
            j= i-1;
            while( j >= 0 && a[j]>temp){//increasing order "a[j]>temp";
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;   
        }    
    }
    public static void print(int arr[]){
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
          }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,8,7,49,1,25,76};
        insertion_sort(arr);
        print(arr);
    }
}
