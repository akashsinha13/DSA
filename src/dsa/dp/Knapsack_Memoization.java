package dsa.dp;

/*
01 knapsack memoization(bottom up dp) implementation
 */
public class Knapsack_Memoization {
    static int knapsack(int wt[], int val[], int W, int n, int[][] dp) {
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        // if element weight is less than total weight
        // choices
        // 1. select last element
        // 2. don't select last element
        // take the maximum of either choices
        if(wt[n-1] <= W) {
            return dp[n][W] = max(val[n-1] + knapsack(wt, val, W- wt[n-1], n-1, dp),
                    knapsack(wt, val, W, n-1, dp));
        } else {
            // if weight is greater, don't select this element
            return dp[n][W] = knapsack(wt, val, W, n-1, dp);
        }
    }

    static int max(int a, int b) {
        return a>b ? a : b;
    }

    public static void main(String[] args) {
        int[] wt = new int[]{ 10, 20, 30 };
        int[] val = new int[]{ 60, 100, 120 };
        int W = 50;
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        // initialize array with -1
        for(int i=0 ; i<= n ; i++) {
            for(int j=0 ; j<=W ; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(wt, val, W, n, dp));
    }
}
