import java.util.*;

public class uppercase {
  
  public static String toUppercase( String s){
    
    StringBuilder sb = new StringBuilder("");
    char ch = Character.toUpperCase(s.charAt(0));
    sb.append(ch);
    
    for(int i = 1 ; i<s.length() ; i++){
        if( s.charAt(i) == ' '  &&  i < s.length()-1 )
        {
           sb.append(s.charAt(i));
            i++;
            sb.append(Character.toUpperCase(s.charAt(i))); 
        }
        else{
            sb.append(s.charAt(i));
        }
    }
    return sb.toString();
  }
    public static void main(String[] args) {
        String s = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
     System.out.println(toUppercase(s));
    }
}
