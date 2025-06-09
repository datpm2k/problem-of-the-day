package algorithms;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {2, 0}, {2, 1}, {1, 3}};

        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            Integer u = edges[i][0];
            Integer v = edges[i][1];
            adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("visiting node: " + node);

            List<Integer> neighbors = adjMap.getOrDefault(node, new ArrayList<>());
            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
