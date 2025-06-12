import java.util.*;

public class Backtracking_Arrays{
    public static void changearr(int arr[], int i, int val){
     //base_case
     if(i == arr.length){
        print(arr);
        return ;
     }
     //Recursion
     arr[i] = val;
     changearr(arr, i+1, val+1);
     arr[i] = arr[i] - 2;//backtracking_step
    }
    public static void print(int arr[]){
        for(int i= 0; i < arr.length ; i++){         
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changearr(arr, 0,1);
        print(arr);
    }
}
