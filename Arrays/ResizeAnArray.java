import java.util.Arrays;

public class ResizeAnArray {
    public static void main(String[] args) {
        System.out.println("Resize An Array");

        int[] originalArray = {1, 2, 3, 4};
        System.out.println("Old Array: " + Arrays.toString(originalArray));

        int[] resizedArray = resizeArray(originalArray, 8);
        System.out.println("New Array: " + Arrays.toString(resizedArray));
    }

    public static int[] resizeArray(int[] originalArray, int newLength) {
        int[] newArray = new int[newLength];
        // for(int i=0; i<originalArray.length; i++){
        //     newArray[i] = originalArray[i];
        // }
        // originalArray = newArray;
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        return newArray;
    }
}
