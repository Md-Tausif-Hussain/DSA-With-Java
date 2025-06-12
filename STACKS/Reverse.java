import java.util.*;
//Company -> Amdocs
public class Reverse{
    public static void Bottom(Stack<Integer> s ,int data){
        if(s.isEmpty()){
            s.push(data);
            return ;
        }
        int top = s.pop();
        Bottom(s,data);
        s.push(top);
    }
    public static void Reverse_Stack(Stack<Integer> s){
        
      if(s.isEmpty()){
        return ;
      }
      int top = s.pop();
      Reverse_Stack(s);
      Bottom(s, top);

    }
    public static void print(Stack<Integer> s ){
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        //original -> 3 2 1
        //print(s);
        Reverse_Stack(s);
        print(s);//reverse -> 1 2 3 
        
    }
}
