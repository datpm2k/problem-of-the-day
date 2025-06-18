package algorithms;


public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        System.out.println(binarySearch(arr, x));
    }

    private static int binarySearch(int[] arr, int x) {
        int l = 0;
        int h = arr.length - 1;

        int mid;
        while (l <= h) {
            mid = l + (h - l) / 2;

            if (arr[mid] == x) return mid;

            if (arr[mid] < x) l = mid + 1;
            else h = mid - 1;
        }

        return -1;
    }
}
