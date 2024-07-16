import java.util.Arrays;

class RemoveEvenInteger {
    public static void main(String[] args) {
        System.out.println("Remove Even Integer");

        int[] arr = {1, 2, 3, 4, 5};

        // Count odd numbers in the array
        int oddCount = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }

        // Create a new array to store only odd numbers
        int[] newArr = new int[oddCount];
        int index = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                newArr[index] = num;
                index++;
            }
        }

        // Print the new array with odd numbers
        System.out.println(Arrays.toString(newArr));
    }
}
