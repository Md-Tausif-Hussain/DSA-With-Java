import java.util.*;
public class DFS{
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

    public static void dfs(ArrayList<Edge> []graph){//function to check Connected components
      boolean vis[] =new boolean[graph.length];
      for(int i=0; i<graph.length;i++){
        if(!vis[i]){
          dfsUtil(graph,i,vis);
        }
      }
    }

    public static void dfsUtil(ArrayList<Edge> graph[],int curr, boolean vis[]){
        //O(V+E)
       //Vist
       System.out.println(curr+" ");
       vis[curr] = true;

       for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]){
            dfsUtil(graph, e.dest, vis);
        }
       }
    }

    public static boolean HasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){
        //O(V+E)
      if(src == dest){
        return true;
      }
      vis[src] = true;
      for(int i=0; i<graph[src].size();i++){
        Edge e = graph[src].get(i);
        if(!vis[e.dest] && HasPath(graph, e.dest, dest, vis)){
            return true;
        }
      }
      return false;
    }
    public static void main(String[] args) {
        int V =5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        dfs(graph);
        System.out.println(HasPath(graph,0,5,new boolean[V]));

    }
}
