import java.util.*;

public class WaterContainer {
    public static int StoreWater(ArrayList<Integer> height){
            int maxWater = 0;
            //bruteForce 
            //timecomplexity = O(n^2)
            for(int i = 0; i <height.size(); i++){
                for(int j =i+1; j<height.size(); j++){
                 int ht = Math.min(height.get(i),height.get(j));
                 int width = j-i;
                 int currWater = ht*width;
                 maxWater = Math.max(maxWater, currWater);
                }
            }

            return maxWater;
    }

    //two pointer approach
    //timecomplexity = O(n)
    public static int Store_Water(ArrayList<Integer> height){
     int maxWater = 0;
     int leftPointer = 0;
     int rightPointer = height.size()-1;

     while(leftPointer < rightPointer){
      //calculate Area
      int ht = Math.min(height.get(leftPointer),height.get(rightPointer));
      int width = rightPointer - leftPointer;
      int currWater = ht*width;
      maxWater = Math.max(maxWater,currWater);

      //update pointer
      if(height.get(leftPointer)< height.get(rightPointer)){
        leftPointer++;
      }
      else{
        rightPointer--;
      }
    }
    
    return maxWater;

}

    public static void main(String[] args) {
        
        ArrayList<Integer> height = new ArrayList<>();
        //1 8 6 2 5 4 8 3 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(StoreWater(height));
        System.out.println();
        System.out.println(Store_Water(height));

    }
}
