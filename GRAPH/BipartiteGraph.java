
import java.util.*;
import java.util.LinkedList;
public class BipartiteGraph{
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
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
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
        
      }

      public static boolean isBipartite(ArrayList<Edge> graph[]){
           int col[] = new int[graph.length];
           for(int i=0; i<col.length;i++){
               col[i] = -1;
           }
           Queue<Integer> q = new LinkedList<>();
           for(int i=0; i<graph.length;i++){
               if(col[i] == -1){//BFS
                q.add(i);
                col[i]=0;
                while (!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(i);
                        if(col[e.dest] == -1){
                            int nextcol = col[curr] == 0 ? 1:0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }else if(col[e.dest] == col[curr]){
                           return false;//Not Bipartit
                        }
                    }
                }

               }
           }
           return true;
      }
    public static void main(String[] args) {
        int V =5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
