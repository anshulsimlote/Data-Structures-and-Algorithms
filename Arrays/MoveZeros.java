import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        System.out.println("Move Zeros");
        int[] arr = {1, 0, 0, 4, 0, 8, 0, 9, 0, 0, 5};
        System.out.println("Before: " + Arrays.toString(arr));
        moveZeros(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }

    public static void moveZeros(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != j) {
                    swap(arr, i, j);
                }
                j++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
