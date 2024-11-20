package Sorting;

public class BubbleSort {
    public static void main(String args[]) {
        System.out.println("Bubble Sort");

        int[] arr = new int[]{1, 6, 3, 5, 4, 2};

        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();

        // Bubble Sort Logic
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
