package algorithms;

import java.util.*;

public class DFS {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {2, 0}, {2, 1}, {1, 3}};

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjMap.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.println("Visiting node: " + node);
            if (!visited.contains(node)) {
                visited.add(node);
                List<Integer> neighbors = adjMap.getOrDefault(node, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
