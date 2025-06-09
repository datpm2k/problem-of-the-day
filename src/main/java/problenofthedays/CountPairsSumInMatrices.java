package problenofthedays;

import java.util.Arrays;

public class CountPairsSumInMatrices {

    public static void main(String[] args) {
        int[][] mat1 = {{1, 5, 6}, {8, 10, 11}, {15, 16, 18}};
        int[][] mat2 = {{2, 4, 7}, {9, 10, 12}, {13, 16, 20}};
        int x = 21;

        // [a:1, b:20] => 1 + 20 = 21 || i:0,j:0
        // [a:5, b:16] => 5 + 16 = 21
        // [a:8, b:13] => 8 + 13 = 21
        // [a:11, b:10] => 11 + 10 = 21

        System.out.println("Number of pairs with sum " + x + ": " + countPairs(mat1, mat2, x));
        System.out.println("Number of pairs with sum v2 " + x + ": " + countPairsV2(mat1, mat2, x));
    }

    /**
     * Expected
     * - Time complexity: O(n^2)
     * - Auxiliary Space: O(1)
     * Actually
     * - Time complexity: O(n^2)
     * - Auxiliary Space: O(n^2)
     * [01, 05, 06]
     * [08, 10, 11]
     * [15, 16, 18]
     * -> [01, 05, 06, 08, 10, 11, 15, 16, 18]
     * ------------
     * [02, 04, 07]
     * [09, 10, 12]
     * [13, 16, 20]
     * -> [02, 04, 07, 09, 10, 12, 13, 16, 20]
     */
    private static int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        int count = 0;

        int[] flatMat1 = Arrays.stream(mat1)
                .flatMapToInt(Arrays::stream)
                .toArray();
        int[] flatMat2 = Arrays.stream(mat2)
                .flatMapToInt(Arrays::stream)
                .toArray();

        int i = 0;
        int j = n * n - 1;
        while (i < n * n && j >= 0) {
            if (flatMat1[i] + flatMat2[j] == x) {
                count++;
                i++;
                j--;
            } else if (flatMat1[i] + flatMat2[j] < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }

    /**
     * Expected
     * - Time complexity: O(n^2)
     * - Auxiliary Space: O(1)
     * Actually
     * - Time complexity: O(n^2)
     * - Auxiliary Space: O(1)
     * [01, 05, 06]
     * [08, 10, 11]
     * [15, 16, 18]
     * ------------
     * [02, 04, 07]
     * [09, 10, 12]
     * [13, 16, 20]
     */
    private static int countPairsV2(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        int m = n * n;
        int i = 0;
        int j = m - 1;

        int count = 0;
        while (i < m && j >= 0) {
            int r1 = mat1[i / n][i % n];
            int r2 = mat2[j / n][j % n];
            int val = r1 + r2;
            if (val == x) {
                count++;
                i++;
                j--;
            } else if (val < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
