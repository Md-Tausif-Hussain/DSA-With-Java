import java.util.*;

//package SORTING;

public class Merge_Sort {

    public static void print(int arr[]){
        for(int i= 0; i < arr.length ; i++){         
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    public static void Recursive_MergeSort(int arr[], int si, int ei){

     if(si >= ei){
        return ;
     }

     int mid = si + (ei - si)/2;
     Recursive_MergeSort(arr, si, mid); //Left_Part
     Recursive_MergeSort(arr, mid + 1, ei); //Right_Part
     Merge(arr, si,mid, ei);
    }
    
    public static void Merge(int arr[], int si , int mid, int ei){
        int temp[] = new int[ei-si+1];

        int i = si;//Left_Part
        int j = mid + 1;//Right_part
        int k = 0;//index for temp

        while( i <= mid+1 && j <= ei){
        
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
           k++;
        }

      //for leftover elements of 1st sorted left_part
      while(i <= mid){
        temp[k++] = arr[i++];
      }
      //for leftover elements of 2nd sorted right_part
      while(j <= ei){
        temp[k++] = arr[j++];
      }

      //copy temp to original arr
      for(k = 0, i = si ; k < temp.length; k++, i++){
        arr[i] = temp[k];
      }


     }
    public static void main(String[] args) {
        //Divide & Conquer Strategy
        //timecomplexity O(nlogn)
        //spacecomplexity O(n)

     int arr[] ={6,3,9,5,2,8};
     Recursive_MergeSort(arr, 0, arr.length-1);
     print(arr);

    }
}
