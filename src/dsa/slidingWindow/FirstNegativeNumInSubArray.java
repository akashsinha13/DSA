package dsa.slidingWindow;

import java.util.ArrayList;
import java.util.List;

/*
    Find first -ve integer in subarray of size k
 */
public class FirstNegativeNumInSubArray {

    private static List<Integer> firstNegNum(int[] arr, int k) {
        int i = 0, j = 0;
        List<Integer> tempList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        while (j < arr.length) {
            if (arr[j] < 0) {
                tempList.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (tempList.size() > 0) {
                    list.add(tempList.get(0));
                } else {
                    list.add(0);
                }

                if (tempList.size() > 0 && arr[i] == tempList.get(0)) {
                    tempList.remove(0);
                }
                i++;
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(firstNegNum(arr, k));
    }
}
