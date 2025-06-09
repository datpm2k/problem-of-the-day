package problenofthedays;

public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] arr2 = {10, 10, 10};
        int[] arr3 = {28078, 19451, 935, 28892, 2242, 3570, 5480, 231};
        int[] arr4 = {10, 5, 10};

        System.out.println(getSecondLargest(arr4));
    }

    static int getSecondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else {
                if (arr[i] > secondLargest && arr[i] != largest) {
                    secondLargest = arr[i];
                }
            }
        }

        return secondLargest;
    }
}
