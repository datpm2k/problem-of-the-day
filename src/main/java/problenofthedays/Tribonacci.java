package problenofthedays;

import java.util.Arrays;

public class Tribonacci {

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(tribTab(n));
        System.out.println(tribMemo(n, dp));
    }

    static int tribMemo(int n, int[] dp) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }

        if (dp[n] != -1) return dp[n];

        dp[n] = tribMemo(n - 1, dp) + tribMemo(n - 2, dp) + tribMemo(n - 3, dp);

        return dp[n];
    }

    static int tribTab(int n) {
        int[] dp = new int[n + 1];
        dp[3] = 1;
        if (n <= 3) {
            return dp[n];
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
