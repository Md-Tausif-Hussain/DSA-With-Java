import java.util.*;

public class MethodOverloading {
    

    public static void main(String args[]){
    
        MethodOverloading obj1 = new MethodOverloading();
        MethodOverloading obj2 = new MethodOverloading(5);
        MethodOverloading obj3 = new MethodOverloading((float)10.5);
       
        Calculator obj = new Calculator();

        System.out.println(obj.sum(10,58));
        System.out.println(obj.sum((float)5.5,(float)6.7));
        System.out.println(obj.sum("IEM & ", "UEM"));
    }


    //It is constructors overloading!!!
    MethodOverloading(){
        System.out.println("I am default constructors!");
    }
    MethodOverloading(int a){
        int area = a*a;
        System.out.println(area);
    }
    MethodOverloading(float f){
        float Area = f*f;
        System.out.println(Area);
    }
    //

    //It is method overloading
 static class Calculator{
    int sum(int a, int b){
        return a+b;
    }

    float sum(float A , float B){
        return A*B;
    }
     
    String sum(String s1, String s2){
        return s1+s2;
    }

 }
    
}
