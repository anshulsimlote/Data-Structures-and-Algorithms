package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Merge Sort  ");
        int[] arr = {2, 10, 5, 3, 6, 4, 11};
        System.out.println("Original array: " + Arrays.toString(arr));
        int n = arr.length;
        mergesort(arr, 0, n - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergesort(int[] arr, int l, int r) {
        if (l < r) { 
            int m = l + (r - l) / 2; // Find the middle point
            mergesort(arr, l, m); // Sort first half
            mergesort(arr, m + 1, r); // Sort second half
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1; // Correct size for the left subarray
        int n2 = r - m; // Correct size for the right subarray

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays
        int i = 0, j = 0;
        int k = l; // Initial index of merged subarray
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
