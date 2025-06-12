import java.util.*;

public class Hash_Set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        System.out.println(set);

        HashSet<String> set2 = new HashSet<>();
        set2.add("Dubai");
        set2.add("UK");
        set2.add("Kolkata");
        set2.add("Australia");

        Iterator it = set2.iterator();
        while(it.hasNext()){
           System.out.println(it.next()); 
        }

        LinkedHashSet<String> s = new LinkedHashSet<>();
        s.add("Dubai");
        s.add("UK");
        s.add("Kolkata");
        s.add("Australia");
        System.out.println(s);

        TreeSet<String> s2 = new TreeSet<>();
        s2.add("Dubai");
        s2.add("UK");
        s2.add("Kolkata");
        s2.add("Australia");
        System.out.println(s2);



    }
}
