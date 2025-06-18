package problenofthedays;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        int k = 8;

        System.out.println(kokoEat(arr, k));
    }

    static int kokoEat(int[] arr, int k) {
        int n = arr.length;
        int l = 1;
        int h = Arrays.stream(arr).max().getAsInt();
        int ans = h;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            int hours = 0;
            for (int i = 0; i < n; i++) {
                hours += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    hours++;
                }
            }

            if (hours <= k) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}
