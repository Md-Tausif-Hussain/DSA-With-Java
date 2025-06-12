import java.util.*;

public class reverse{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r ;

        while(n>0)
        {
            r=n%10;
            System.out.print4(""+r);
            n=n/10;
        }
        System.out.println();
    }
}