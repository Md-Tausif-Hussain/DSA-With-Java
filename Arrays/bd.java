import java.util.*;

public class bd {

    //Binary to decimal

    public static void binTodec(int bin)
    {
        int pow = 0;
        int num = bin;
        int dec = 0;//decimal

        while( bin> 0)
        {
            int r = bin % 10;
            dec = dec + (r*(int)Math.pow(2,pow));
            pow++ ;
            bin = bin/10;
        }

        System.out.println("decimal of "+num + " = "+dec);
    }
    public static void main(String[] args) {

        binTodec(111);
        
    }
}
