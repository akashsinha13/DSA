package dsa.slidingWindow;

/*
Find the maximum sum from subarray of size k
 */
public class MaxSumSubArray {

    private static int maxSumSubArray(int[] arr, int k) {
        int j = 0, i = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 8, 2, 0, 1};
        int k = 3;
        System.out.println(maxSumSubArray(arr, k));
    }
}
