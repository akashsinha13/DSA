package dsa.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/*
    Find the maximum value of all subarray of size k
 */
public class MaxValueSubArray {

    private static List<Integer> maxValSubArray(int[] arr, int k) {
        List<Integer> maxList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int i = 0, j = 0;
        while (j < arr.length) {
            if (tempList.size() > 0 && tempList.get(0) < arr[j]) {
                tempList.clear();
            }
            tempList.add(arr[j]);
            if(j-i+1 < k) {
                j++;
            }
            else if(j-i+1 == k) {
                maxList.add(tempList.get(0));
                if(arr[i] == tempList.get(0)) {
                    tempList.remove(0);
                }
                i++;
                j++;
            }
        }
        return maxList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 8, 2, 0, 1};
        int k = 3;
        System.out.println(maxValSubArray(arr, k));
    }
}
