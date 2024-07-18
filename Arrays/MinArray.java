public class MinArray {
    public static void main(String[] args) {
        System.out.println("Minimum in an Array");
        int[] arr = {9, 2, 3, 5, 6, 9, 8, 6, 2, 1, 3, 5, 6, 10};
        int min = findMin(arr);
        System.out.println("Minimum in an Array is " + min);
    }

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int min = arr[0];
        for (int val : arr) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }
}
