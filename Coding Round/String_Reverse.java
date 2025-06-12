import java.util.*;
public class String_Reverse {
    public static void main(String[] args) {
        String s = "Hello World";
         //stringbuilder approach
        StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.reverse();
        System.out.println(s1);

    }
}
