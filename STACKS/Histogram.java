import  java.util.*;
//Microsoft PayTM Facebook
public class Histogram {
    public static void MaxArea(int arr[]){
        int Max_Area =0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
              nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
          s.push(i);
        }

        //Next Smaller Left
         s = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
              nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
          s.push(i);
        }
        //Current Area
        for(int i =0; i<arr.length; i++){
            int height = arr[i];
            int weidth = nsr[i] - nsl[i] -1;
            int currArea = height*weidth;
            Max_Area = Math.max(currArea,Max_Area);
        }
        System.out.println("Maximum area in Histogram = "+Max_Area);
    }
    public static void main(String[] args) {
        int arr[] = {2,4};//Heights In Histogram
        MaxArea(arr);

    }
}
