package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println("Insertion Sort");
        int[] arr = new int[]{3,1,5,2,6,4};
        System.out.println("Before "+Arrays.toString(arr));
        for(int i=1;i<arr.length;i++){
            int temp = arr[i];
            int j=i-1;
            while(j>=0 && arr[j] > temp ){
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = temp;
        }
        System.out.println("After "+Arrays.toString(arr));
    }
}
