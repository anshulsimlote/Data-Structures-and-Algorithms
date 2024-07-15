import java.util.Arrays;

class InitializationOfArray {
    public static void main(String[] args){
        System.out.println("Initialization Of Array");
        
        // Method 1: Declare and allocate array
        int[] arr1 = new int[5]; // Initializes an array of size 5 with default values (0)
        
        // Method 2: Alternative syntax for array declaration and allocation
        int arr2[] = new int[5]; // Initializes an array of size 5 with default values (0)
        
        // Method 3: Declare, allocate, and initialize array with values
        int arr3[] = {1, 2, 3, 4, 5}; // Initializes an array with specified values

        // Additional print statements to verify initialization
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("arr3: " + Arrays.toString(arr3));
    }
}