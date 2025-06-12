import java.util.*;

class TopologicalSortingBFS {
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

    public static void CalcIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        CalcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 10;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
