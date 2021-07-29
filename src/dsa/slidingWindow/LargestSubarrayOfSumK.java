package dsa.slidingWindow;

/*
Returns the size of largest subarray with sum k
Valid only for arrays with positive integers
 */
public class LargestSubarrayOfSumK {

    public static int largestSubArray(int[] arr, int sum) {
        int max = -1;
        int i = 0, j = 0;
        int total = 0;
        while (j < arr.length) {
            total += arr[j];
            if (total < sum) {
                j++;
            } else if (total == sum) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (total > sum) {
                    total -= arr[i];
                    i++;
                }
                if (total == sum) {
                    max = Math.max(max, j - i + 1);
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 1, 1, 2, 6, 5};
        int sum = 5;
        System.out.println(largestSubArray(arr, sum));
    }
}
