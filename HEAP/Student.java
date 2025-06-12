import java.util.*;

public class Student {
    static class Students implements Comparable<Students> {
        String name;
        int rank;

        public Students(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Students s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Students> pq = new PriorityQueue<>();

        pq.add(new Students("A", 2));
        pq.add(new Students("B", 6));
        pq.add(new Students("C", 1));
        pq.add(new Students("D", 5));

        while (!pq.isEmpty()) {
            Students s = pq.peek();
            System.out.println(s.name + " -> " + s.rank); // O(1)
            pq.remove(); // O(logn)
        }
    }
}
