package problenofthedays;

public class LcsOfThreeStrings {

    public static void main(String[] args) {
        String s1 = "geeks";
        String s2 = "geeksfor";
        String s3 = "geeksforgeeks";

        System.out.println("LCS of two is: " + lcsOfTwo(s1, s2));
        System.out.println("LCS of three is: " + lcsOfThree(s1, s2, s3));
    }

    /**
     * Time: O(n1 * n2 * n3)
     * Space: O(n1 * n2 * n3)
     */
    static int lcsOfThree(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // dp[0][j][k] = dp[i][0][k] = dp[i][j][0] = 0
        // để dp[i - 1][j - 1][k - 1] không bị out of bound
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k],
                                Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        return dp[n1][n2][n3];
    }

    /**
     * s1: geeks
     * s2: geeksfor
     * [[1][1][1][1][1][1][1][1]]
     * [[0][2][2][2][2][2][2][2]]
     * [[0][1][3][3][3][3][3][3]]
     * [[0][1][3][4][4][4][4][4]]
     * [[0][1][3][4][5][5][5][5]]
     */
    static int lcsOfTwo(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
