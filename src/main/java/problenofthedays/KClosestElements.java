package problenofthedays;

import java.util.*;

public class KClosestElements {

    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 50};
        int k = 4;
        int x = 36;

        System.out.println("K closest elements: " + Arrays.toString(printKClosest(arr, k, x)));
    }

    static int[] printKClosest(int[] arr, int k, int x) {
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k,
                (a, b) -> {
                    if (Objects.equals(a.getKey(), b.getKey())) {
                        return b.getValue() - a.getValue();
                    }
                    return a.getKey().compareTo(b.getKey());
                });
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] != x) {
                q.add(new AbstractMap.SimpleEntry<>(Math.abs(arr[i] - x), i));
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> kv = q.poll();
            ans[i] = arr[kv.getValue()];
        }

        return ans;
    }
}
