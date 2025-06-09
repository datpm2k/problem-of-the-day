package problenofthedays;

import java.util.*;

public class CountPaths {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {2, 0}, {2, 1}, {1, 3}};

        System.out.println("Count the paths: " + countPaths(edges, 4, 2, 3));
    }

    /**
     * O(V + )
     * @param edges
     * @param V
     * @param src
     * @param dest
     * @return
     */
    private static int countPaths(int[][] edges, int V, int src, int dest) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(src);

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(initialPath);

        while (!q.isEmpty()) {
            List<Integer> currPath = q.poll();

            int u = currPath.get(currPath.size() - 1);
            if (u == dest) {
                ArrayList<Integer> matchPath = new ArrayList<>(currPath);
                paths.add(matchPath);
            }

            List<Integer> neighbors = adjMap.getOrDefault(currPath.get(currPath.size() - 1), new ArrayList<>());
            for (Integer neighbor : neighbors) {
                ArrayList<Integer> neighborPath = new ArrayList<>(currPath);
                neighborPath.add(neighbor);
                q.add(neighborPath);
            }
        }

        return paths.size();
    }
}
