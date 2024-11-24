package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Selection Sort");
        int[] arr = new int[]{3, 1, 5, 2, 6, 4};
        
        System.out.println("Before: " + Arrays.toString(arr));
        
        // Selection Sort Algorithm
        for (int i = 0; i < arr.length - 1; i++) { // Loop till second last element
            int minIndex = i;
            
            // Find the index of the smallest element in the remaining unsorted array
            for (int j = i + 1; j < arr.length; j++) { 
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted array
            if (minIndex != i) { // Swap only if a smaller element is found
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        
        System.out.println("After: " + Arrays.toString(arr));
    }
}
