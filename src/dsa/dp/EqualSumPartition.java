package dsa.dp;

import java.util.Arrays;

/*
equal sum partition top down implementation
 */
public class EqualSumPartition {
    static boolean isEqualSumPartition(int[] arr, int sum, int n, boolean[][] t) {
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
        int[] arr = new int[]{3, 1, 5, 9, 12};
        int sum = Arrays.stream(arr).sum();
        if(sum%2 == 0) {
            sum /= 2;
            int n = arr.length;
            boolean[][] t = new boolean[n+1][sum+1];
            System.out.println(isEqualSumPartition(arr,sum,n,t));
        } else {
            System.out.println(false);
        }

    }
}
