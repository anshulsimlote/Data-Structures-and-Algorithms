public class SecondMax {
    public static void main(String[] args){
        System.out.println("Second Maximum in an Array");
        int[] arr = {9, 2, 3, 5, 6, 9, 8, 6, 2, 1, 3, 5, 6, 10};
        int secondMax = findSecondMaxMin(arr);
        System.out.println("Second Maximum in an Array is " + secondMax);
    }

    public static int findSecondMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int secondMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > max) {
                secondMax = max;
                max = val;
            }else if(val > secondMax && max != val ){
                secondMax = val;
            }
        }
        return secondMax;
    }
}
