package problenofthedays;

public class DecodeWays {
    public static void main(String[] args) {
        String digits = "123";
        System.out.println(countWays(digits));
    }

    static int countWays(String digits) {
        int n = digits.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(digits.charAt(i) - '0' != 0) {
                dp[i] = dp[i + 1];
            }

            if (i + 1 < n && (digits.charAt(i) - '0') * 10 + (digits.charAt(i + 1) - '0') <= 26) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }
}
