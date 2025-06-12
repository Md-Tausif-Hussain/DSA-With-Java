import java.util.*;

public class Count_Distinct_Elements {
    public static void main(String[] args) {
        int arr[]= {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();

        for(int i =0; i<arr.length;i++){
            set.add(arr[i]);
        }
        System.out.println("Ans : "+set.size());
    }
}
