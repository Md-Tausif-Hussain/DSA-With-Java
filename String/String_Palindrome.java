import java.util.*;
public class String_Palindrome {
    public static boolean isPalindrome(String str){
        for(int i =0 ; i<str.length()/2;i++){
            //int n = str.length();
            if (str.charAt(i) != str.charAt(str.length()-1-i)){
                //not palindrome
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
}
