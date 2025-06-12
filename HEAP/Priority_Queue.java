import java.util.*;
import java.util.PriorityQueue;

public class Priority_Queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);//O(logn)
        pq.add(5);
        pq.add(7);
        pq.add(1);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());//O(1)
            pq.remove();//O(logn)
        }
    }
}
