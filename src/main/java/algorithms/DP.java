package algorithms;

import java.util.Arrays;

public class DP {

    public static void main(String[] args) {
        int n = 50;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);

        long st = System.currentTimeMillis();
        System.out.println(fibRecur(n));
        long et = System.currentTimeMillis();
        System.out.println("Recur: " + (et - st) + " ms");

        System.out.println(fibMem(n, mem));
        et = System.currentTimeMillis();
        System.out.println("Memo: " + (et - st) + " ms");
        
        System.out.println(fibTab(n));
        et = System.currentTimeMillis();
        System.out.println("Tab: " + (et - st) + " ms");
    }

    /**
     * Native recursive approach
     */
    static int fibRecur(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecur(n - 1) + fibRecur(n - 2);
    }

    /**
     * Memoization approach
     */
    static int fibMem(int n, int[] mem) {
        if (n <= 1) {
            return n;
        }

        if (mem[n] != -1) {
            return mem[n];
        }

        mem[n] = fibMem(n - 1, mem) + fibMem(n - 2, mem);

        return mem[n];
    }

    static int fibTab(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
