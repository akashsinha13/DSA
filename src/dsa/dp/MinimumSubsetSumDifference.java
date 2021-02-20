package dsa.dp;

import java.util.Arrays;

/*
Minimum subset sum difference top down implementation
 */
public class MinimumSubsetSumDifference {
    static boolean subsetSum(int[] arr, int sum, int n, boolean[][] t) {
        // initialization
        // for sum =0, we can have only one set i.e. {}
        for(int i=0; i<=n; i++){
            t[i][0] = true;
        }
        // we can't create set with no element if sum>0
        for(int j=1; j<=sum; j++) {
            t[0][j] = false;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum ; j++){
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] || t[i-1][j- arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 11, 5};
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        int diff = Integer.MAX_VALUE;
        subsetSum(arr,sum,n,t);

        // find the largest j such that t[n][j]
        // is true where j loops from sum/2 to 1
        for(int j=sum/2 ; j>=1 ; j--) {
            if(t[n][j]){
                // diff = s2 - s1
                // sum = s1 + s2
                // diff = sum - 2s1
                diff = sum - 2*j;
                break;
            }
        }

        System.out.println(diff);
    }
}
