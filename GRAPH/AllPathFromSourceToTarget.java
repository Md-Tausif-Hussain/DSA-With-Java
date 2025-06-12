import java.util.*;

public class AllPathFromSourceToTarget {
    static class Edge {
        int src; // Source
        int dest; // Destination
        int wt; // Weight

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

    public static void PrintAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            PrintAllPath(graph, e.dest, dest, path + src + " -> ");
        }
    }

    public static void main(String[] args) {
        int V = 10;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src = 2, dest = 5;
        PrintAllPath(graph, src, dest, "");
    }
}
