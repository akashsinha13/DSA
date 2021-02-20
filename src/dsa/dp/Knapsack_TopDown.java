package dsa.dp;

/*
01 knapsack top down implementation
 */
public class Knapsack_TopDown {

    static int knapsack(int[] wt, int[] val, int W, int n, int[][] t) {
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=W ; j++){
                if(wt[i-1] <= j) {
                    t[i][j] = max(val[i-1] + t[i-1][j - wt[i-1]],t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][W];
    }

    static int max(int a, int b) {
        return a>b ? a: b;
    }

    public static void main(String[] args) {
        int[] wt = new int[]{10, 20, 30};
        int[] val = new int[]{60, 100, 120};
        int W = 50;
        int n = wt.length;
        int[][] t = new int[n+1][W+1];
        System.out.println(knapsack(wt, val, W, n, t));
    }
}
