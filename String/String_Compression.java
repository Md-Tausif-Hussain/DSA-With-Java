import java.util.*;
public class String_Compression {
    //string Builder Approach
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            s.append(str.charAt(i));
            if (count > 1) {
                s.append(count);
            }
        }
        return s.toString();
    }
    public static void main(String[] args) {
        String s = "aaabbcccdd";
        System.out.println(compress(s)); // Output should be "a3b2c3d2"
    }    
}
