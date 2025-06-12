
import java.util.*;

public class FirstProgram {
public static void main(String[] args) {

    //create
    HashMap<String,Integer> hm = new HashMap<>();
    
    //Insert O(1)
    hm.put("India", 100);
    hm.put("Dubai", 250);
    hm.put("Australia", 500);
    hm.put("Berlin", 600);

    System.out.println(hm);
    //Get O(1)
    int i = hm.get("India");
    System.out.println(i);

    System.out.println(hm.get("Indonesia"));

    //ContainsKey - O(1)
    System.out.println(hm.containsKey("India"));
    System.out.println(hm.containsKey("UAE"));

    //Remove
    System.out.println(hm.remove("Dubai"));
    System.out.println(hm);

    System.out.println(hm.size());

    //Iterate
    Set<String> keys = hm.keySet();
    System.out.println(keys);

    for(String s : keys){
        System.out.println("Keys = "+s+" ,Value :"+hm.get(s));
    }
     
    System.out.println();
    System.out.println(hm.entrySet());


}    
}
