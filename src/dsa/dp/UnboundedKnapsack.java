package dsa.dp;

/*
Unbounded knapsack top down implementation
 */
public class UnboundedKnapsack {
    static int knapsack(int[] wt, int[] val, int W, int n, int[][] t) {
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=W ; j++){
                if(wt[i-1] <= j) {
                    t[i][j] = max(val[i-1] + t[i][j - wt[i-1]],t[i-1][j]);
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
        int[] wt = new int[]{5, 10, 15};
        int[] val = new int[]{10, 30, 20};
        int W = 100;
        int n = wt.length;
        int[][] t = new int[n + 1][W + 1];
        System.out.println(knapsack(wt, val, W, n, t));
    }
}

