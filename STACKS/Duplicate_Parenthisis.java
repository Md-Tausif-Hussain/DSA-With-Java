import java.util.*;
//Time_Complexity = O(n)
public class Duplicate_Parenthisis {
    public static boolean isDuplicate(String str){
         Stack<Character> s = new Stack<>();

         for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);
            //closing
            if(ch == ')'){
                int count =0;
                while (!s.isEmpty() && s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;//duplicate
                }
                else{
                    s.pop();//opening pair
                }
            }
            else{//Opening
              s.push(ch);
            }
         }
         return false;
    }
    public static void main(String[] args) {
        String s1 = "((a+b))";//true
        String s2 = "(a-b)";//false

        System.out.println(isDuplicate(s1));
        System.out.println(isDuplicate(s2));


    }
}
