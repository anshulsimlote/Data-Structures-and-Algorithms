package Searching;

public class LinearSearch {
    public static void main(String[] args) {
        System.out.println("Linear Search");
        int[] arr = {1, 2, 4, 5, 6, 11, 3};
        int target1 = 4;
        int target2 = 41;

        // Search for target1
        int result1 = search(arr, target1);
        System.out.println(result1 != -1 ? "Element " + target1 + " found at index " + result1 : "Element " + target1 + " not found");

        // Search for target2
        int result2 = search(arr, target2);
        System.out.println(result2 != -1 ? "Element " + target2 + " found at index " + result2 : "Element " + target2 + " not found");
    }

    // Search method that returns the index of the target if found, or -1 if not found
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the element if found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }
}
