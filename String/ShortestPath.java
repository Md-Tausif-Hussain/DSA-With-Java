import java.util.*;
public class ShortestPath
{
public static float getshortestpath( String path)
{   int x = 0 , y = 0;
    for(int i = 0; i<path.length() ; i++)
    {
     char c = path.charAt(i);
     //North
     if( c == 'N'){
        y++;
     }
     //South
     else if ( c == 'S'){
        y--;
     }
    //East
     else if ( c == 'E'){
        x++;
     }
     //West
     else{
        x--;
     }
    }
   int X2 = x*x;
   int Y2 = y*y;
   return (float)Math.sqrt(X2 + Y2);
}
public static void main(String[] args)
{  
 String path = "NSEW";
 System.out.println(getshortestpath(path));
}
}