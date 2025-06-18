package problenofthedays;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] cost = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        System.out.println("Minimum cost path: " + minCostPath(cost));
    }

    private static int minCostPath(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = cost[0][0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + cost[i - 1][0];
        }
        for(int i = 1; i < m; i++) {
            dp[0][i] = cost[0][i] + cost[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + cost[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
