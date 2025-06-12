import java.util.*;

public class HollowRhombus {
    public static void pattern(int n){
        for(int i=1; i<=n; i++){

            //space
            for(int j=1; j<=(n-i);j++){
                System.out.print(" ");
            }

            //stars
            for(int j=1; j<=n; j++){
                if(i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 7;
        pattern(n);
    }
}
