import java.util.*;

public class Backtracking_Permutation {
public static void findpermutation(String str, String ans){
    //basecase
     if(str.length()==0){
        System.out.println(ans);
     }
    //recursion
    for(int i = 0; i < str.length(); i++){
        char c = str.charAt(i);
        String Newstr = str.substring(0, i) + str.substring(i+1);
        findpermutation(Newstr, ans+c);
    }
}
    public static void main(String[] args) {
    String str = "abc";
     findpermutation(str,"");
        
    }
}
