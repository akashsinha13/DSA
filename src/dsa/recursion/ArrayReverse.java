package dsa.recursion;

import java.util.Arrays;

/*
Reverse an array using recursion
 */
public class ArrayReverse {

    public static void reverse(int[] arr, int l, int r) {
        if(l>r) {
            return;
        }

        reverse(arr, l+1, r-1);
        swap(arr, l, r);

    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int n = arr.length;
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
