import java.util.*;

public class Topological_Sorting {
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

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Creating a DAG
        // Vertex 0
        graph[0].add(new Edge(0, 1, 1));
        // Vertex 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        // Vertex 2
        graph[2].add(new Edge(2, 4, 1));
        // Vertex 3
        graph[3].add(new Edge(3, 4, 1));
        // Vertex 4
        graph[4].add(new Edge(4, 5, 1));
        // Vertex 5
        graph[5].add(new Edge(5, 6, 1));
        // Vertex 6
        graph[6].add(new Edge(6, 7, 1));
        // Vertex 7
        graph[7].add(new Edge(7, 8, 1));
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 9;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
