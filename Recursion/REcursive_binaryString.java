public class REcursive_binaryString {
    
    public static void print( int n , int LastPlace, String str){
        //paytm_questions
        
       if(n == 0){//Base_Case
        System.out.println(str);
        return;
       }

        print(n-1, 0, str+"0");
            
         if(LastPlace == 0){
            print(n-1, 1, str+"1");
         }
        
    }
    
    public static void main(String[] args) {

        print(3, 0,"");
        
    }
}
