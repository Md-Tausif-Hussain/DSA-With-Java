import java.util.*;

public class tax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int income = sc.nextInt();
        System.out.println("Your income :"+income);
        int tax;

        if(income < 500000){
            System.out.println("There is zero tax in your income");
        }

        else if(income >= 500000 && income <= 1000000){
            tax =(int)(income*0.2);
            System.out.println("Your Income Tax is :"+tax);
        }

        else{
            tax = (int)(income*0.3);
            System.out.println("Your Income Tax is :"+tax);
        }
        
    }


    
}
