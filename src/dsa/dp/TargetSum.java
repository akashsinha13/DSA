package dsa.dp;

import java.util.Arrays;

/*
Target sum (Leet code question) top down implementation
 */
public class TargetSum {
    static int targetSum(int[] arr, int sum, int n, int[][] t) {
        // initialization
        // for sum =0, we can have only one set i.e. {}
        for(int i=0; i<=n; i++){
            t[i][0] = 1;
        }
        // we can't create set with no element if sum>0
        for(int j=1; j<=sum; j++) {
            t[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum ; j++){
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j] + t[i-1][j- arr[i-1]];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int sum = Arrays.stream(arr).sum();
        // s1 + s2 = sum
        // s1 - s2 = target
        // s1 = (sum + target)/2
        int cal = (target + sum)/2;
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        System.out.println(targetSum(arr,cal,n,t));
    }
}
