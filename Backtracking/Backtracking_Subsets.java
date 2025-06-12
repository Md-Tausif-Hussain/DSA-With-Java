public class Backtracking_Subsets {
    public static void findsubsets(String str ,String ans, int i){
    //basecase
    if(i == str.length()){
        if(ans.length() == 0){
            System.out.println("null");
        }
        else{
            System.out.println(ans);
        }
        
        return ;
    }

    //recursion
    //yes_choice
    findsubsets(str, ans+str.charAt(i), i+1);
    //no_ choice
    findsubsets(str, ans, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        findsubsets(str, "", 0);
    }
}
