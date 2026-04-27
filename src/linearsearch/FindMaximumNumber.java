package linearsearch;

public class FindMaximumNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 30, 5};
        System.out.println(max(arr));
        System.out.println(maxRange(arr, 1, 3));
    }

    static int max(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static int maxRange(int[] arr, int start, int end) {
        if (start > end || arr.length == 0 || arr == null) {
            return -1;
        }
        int max = arr[start];
        for (int i = start; i <= end; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
