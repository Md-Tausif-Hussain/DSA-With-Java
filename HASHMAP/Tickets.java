import java.util.*;
public class Tickets{
    public static String getStart(HashMap<String, String> ticket){
     HashMap<String,String> revMap = new HashMap<>();
     for(String key : ticket.keySet()){
        revMap.put(ticket.get(key), key);
     }
     for(String key : ticket.keySet()){
        if(!revMap.containsKey(key)){
            return key;//Starting point
        }
     }
     return null;
    }
    
    public static void main(String[] args) {
        HashMap<String, String> ticket = new HashMap<>();
        ticket.put("Chennai", "Banglore");
        ticket.put("Mumbai", "Delhi");
        ticket.put("Goa", "Chennai");
        ticket.put("Delhi", "Goa");
        
        String s = getStart(ticket);
        System.out.println(s);

        for(String key : ticket.keySet()){
            System.out.println("->"+ticket.get(s));
            s = ticket.get(s);
        }
        System.out.println();
    }
}