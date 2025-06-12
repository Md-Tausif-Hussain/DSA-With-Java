import java.util.*;
import java.util.LinkedList;

public class QueueUsingDeque {

    static class Queue{
        Deque<Integer> d = new LinkedList<>();
  
        public void push(int data){
          d.addLast(data);
        }
  
        public int pop(){
          return d.removeFirst();
        }
  
        public int peek(){
          return d.getFirst();
        }
      }
  
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println("Peek = "+q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
