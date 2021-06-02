package dsa.stack;

import java.util.Arrays;

/*
Calculate the max amt of water store between buildings
 */
public class RainWaterTrapping {

    private static int rainWaterTrapping(int[] arr, int n) {
        int left = -1, right = -1;
        int[] leftArr = new int[n];
        int[] rightArr = new int[n];

        // Find left tallest building
        for(int i=0; i<n; i++) {
            if(left < arr[i]) {
                left = arr[i];
            }
            leftArr[i] = left;
        }

        // Find right tallest building
        for(int i=n-1; i>=0 ; i--) {
            if(right < arr[i]) {
                right = arr[i];
            }
            rightArr[i] = right;
        }

        int area=0;
        for(int i=0; i<n; i++) {
            area += Math.min(leftArr[i], rightArr[i])- arr[i];
        }
        return area;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(rainWaterTrapping(arr, arr.length));
    }
}
