import java.util.*;

public class String_Palindrome {
    public static void main(String[] args) {
        String s = "wow";
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.reverse();

        if(s.equals(s1.toString())){
            System.out.println("Palindrome Number !");
        }
        else{
            System.out.println("Not palindrome !");
        }
    }
}
