public class Recursive_DuplicateString {
    //Microsoft_questions
    //Google_Questions

    public static void removeduplicate(String str, int index , StringBuilder newstr , boolean map[]){
        if(index == str.length()){//base_case
            System.out.print(newstr);
            return ;
        }
       
     char c = str.charAt(index);//current_character
     
     if(map[ c - 'a'] == true){
        //duplicate
       removeduplicate(str, index+1, newstr, map);
     }
     else{
        map[c - 'a'] = true;
        removeduplicate(str, index+1, newstr.append(c), map);
     }

    }
    public static void main(String[] args) {
        String str = "appnnacolleg";

        removeduplicate(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
