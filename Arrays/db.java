import java.util.*;

public class bd {

    //Decimal to binary
    public static void dectobin(int n)
    {
        int pow = 0;
        int num = n;
        int bin = 0;

        while( n > 0)
        {
            int r = n % 2;
            bin = bin + (r*(int)Math.pow(10,pow));
            pow++ ;
            n = n/2;
        }

        System.out.println("Binary form of "+num + " = "+bin);
    }
    public static void main(String[] args) {

        dectobin(111);
        
    }
}
