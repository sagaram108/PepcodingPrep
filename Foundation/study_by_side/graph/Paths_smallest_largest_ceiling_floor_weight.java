package study_by_side.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Paths_smallest_largest_ceiling_floor_weight {
    static class Edge {
        int src;
        int nbr;
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
        paths(graph, 0, 6, visited, 39, 4, "0", 0);

        System.out.println(smallestPath + " => " + smallestPathWeight);
        System.out.println(largestPath + " => " + largestPathWeight);
        System.out.println(ceilPath + " => " + ceilPathWeight);
        System.out.println(floorPath + " => " + floorPathWeight);

//        kth largest
        System.out.println("kth largest " + pq.peek().pathSoFar + " => " + pq.peek().pathSoFarWeight);
    }

    static String smallestPath;
    static Integer smallestPathWeight = Integer.MAX_VALUE;
    static String largestPath;
    static Integer largestPathWeight = Integer.MIN_VALUE;
    static String ceilPath;
    static Integer ceilPathWeight = Integer.MAX_VALUE;
    static String floorPath;
    static Integer floorPathWeight = Integer.MIN_VALUE;

    static class Pair implements Comparable<Pair> {
        String pathSoFar;
        int pathSoFarWeight;

        public Pair(String pathSoFar, int pathSoFarWeight) {
            this.pathSoFar = pathSoFar;
            this.pathSoFarWeight = pathSoFarWeight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.pathSoFarWeight - o.pathSoFarWeight;
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void paths(ArrayList<Edge>[] graph, int src, int des, boolean[] visited,
                             int criteria, int k, String pathSoFar, int weightSoFar) {

        if (src == des) {
            if (weightSoFar < smallestPathWeight) {
                smallestPathWeight = weightSoFar;
                smallestPath = pathSoFar;
            }

            if (weightSoFar > largestPathWeight) {
                largestPathWeight = weightSoFar;
                largestPath = pathSoFar;
            }

            if (weightSoFar > criteria && weightSoFar < ceilPathWeight) {
                ceilPathWeight = weightSoFar;
                ceilPath = pathSoFar;
            }

            if (weightSoFar < criteria && weightSoFar > floorPathWeight) {
                floorPathWeight = weightSoFar;
                floorPath = pathSoFar;
            }

            if (pq.size() < k) {
                pq.add(new Pair(pathSoFar, weightSoFar));
            }else {
                if (weightSoFar > pq.peek().pathSoFarWeight) {
                    pq.remove();
                    pq.add(new Pair(pathSoFar, weightSoFar));
                }
            }

            return;
        }

        visited[src] = true;
        for (Edge edge: graph[src]) {
            if (visited[edge.nbr] == false)
                paths(graph, edge.nbr, des, visited, criteria, k , pathSoFar +
                        edge.nbr, weightSoFar + edge.wt);
        }
        visited[src] = false;
    }
}
