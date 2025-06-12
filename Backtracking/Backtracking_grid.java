public class Backtracking_grid {
    public static int grid_ways(int i, int j , int r, int c){
        //BASE_CASE
        if(i == r-1 && j == c-1){//condition for last cell
            return 1;
        }
        else if(i == r || j == c){//Boundary cross condition
        return 0 ;
        }
        int w1 = grid_ways(i+1, j, r, c);
        int w2 = grid_ways(i, j+1, r, c);
        return w1+w2;
        }
    public static void main(String[] args) {
        int r= 3, c= 3;
      System.out.println(grid_ways(0, 0, r, c));
    }
}
