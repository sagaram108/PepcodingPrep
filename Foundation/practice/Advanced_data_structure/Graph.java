package practice.Advanced_data_structure;
// Multi-cursor shortcut = shift + ctrl + alt + j
import java.util.ArrayList;

public class Graph {

    public static class Edge {
        int src;
        public int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vertices = 7; // 0 1 2 3 4 5 6
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i=0; i< vertices; i++)
            graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 8));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 4, 8));
        graph[6].add(new Edge(6, 5, 3));

        boolean[] visited = new boolean[vertices];
//        boolean hasPath = has_path(graph, 3, 6, visited);
//        System.out.println(hasPath);

        print_All_Paths(graph, 0, 6, visited, "0");
    }

    public static boolean has_path(ArrayList<Edge>[] graph, int src, int des, boolean[] visited) {
        if (src == des) return true;

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                boolean hasNbrPath = has_path(graph, edge.nbr, des, visited);
                if (hasNbrPath == true) return true;
            }
        }

        return false;
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void print_All_Paths(ArrayList<Edge>[] graph, int src, int des, boolean[] visited, String pathSoFar) {
        if (src == des) {
            System.out.println(pathSoFar);
            return;
        }

        visited[src] = true;
        for (var edge: graph[src]) {
            if (visited[edge.nbr] == false) {
                print_All_Paths(graph, edge.nbr, des, visited, pathSoFar + edge.nbr);
            }
        }
        visited[src] = false;
    }
}
