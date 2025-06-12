import java.util.*;
public class DIJKSTRA_ALGORITHM{
    static class Edge {
        int src;  // Source
        int dest; // Destination
        int wt;   // Weight

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }

    static class Pair implements Comparable<Pair> {
    int n, path;
    public Pair(int n, int path){
      this.n = n;
      this.path = path;
    }

    @Override
    public int compareTo(Pair p2){
        return this.path - p2.path;//path based sorting for my pairs
    } 
    }

    public static void dijkstra(ArrayList<Edge>graph[], int src){
       int dist[] = new int[graph.length];//dist[i] -> src[i]
       for(int i=0; i<graph.length;i++){
        if(i != src){
            dist[i] = Integer.MAX_VALUE;//+Infinity
        }
       }

       boolean vis[] = new boolean[graph.length];
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(src, 0));
       
       while(!pq.isEmpty()){
        Pair curr = pq.remove();
        if(!vis[curr.n]){
            vis[curr.n] = true;
            //Neighbours
           for(int i=0; i<graph[curr.n].size();i++){
            Edge e = graph[curr.n].get(i);
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if(dist[u]+wt < dist[v]){//update distance of src to V
                dist[v] = dist[u]+wt;
                pq.add(new Pair(v, dist[v]));
            }
           }
        }
       }
       //print
       for(int i=0; i<dist.length; i++){
        System.out.print(dist[i]+" ");
       }
       System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src=0;
        dijkstra(graph, src);
    }
}
