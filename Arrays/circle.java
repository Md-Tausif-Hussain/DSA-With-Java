import java.util.*;

public class circle{

     public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);

       float r = sc.nextFloat();
       System.out.println("Radius for circle :"+r);
       
       float a = 3.14f * (r*r);
       System.out.println("Area of Circle is :"+a );

    }
}