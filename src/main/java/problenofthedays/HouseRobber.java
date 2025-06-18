package problenofthedays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] hval = {5, 3, 4, 11, 2};

        System.out.println(maxLoot(hval));
    }

    private static int maxLoot(int[] hval) {
        int n = hval.length;

        int[] dp = new int[n + 1];
        dp[1] = hval[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(hval[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }
}
