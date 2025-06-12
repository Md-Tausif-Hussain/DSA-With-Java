import java.util.*;
public class AdjacencyList {
    static class Edge{
        int src;//Source
        int dest;//Destination
        int wt;//Weight

        public Edge(int s, int d, int w){
         this.src = s;
         this.dest = d;
         this.wt = w;
        }
    }
    public static void main(String[] args) {
        int V =5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        //Vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //Vertex 1
        graph[1].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(0, 3, 3));

        //Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 4));
        graph[2].add(new Edge(2, 4, 4));

        //Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        //Vertex 4
        graph[4].add(new Edge(4, 2, 1));

        //2's Neighbor
        for(int i=0; i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }   
}