package dsa.dp;

public class RodCutting {
    static int rodCutting(int[] len, int[] val, int W, int n, int[][] t) {
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=W ; j++){
                if(len[i-1] <= j) {
                    t[i][j] = max(val[i-1] + t[i][j - len[i-1]],t[i-1][j]);
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
        int[] len = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] val = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int W = 8;
        int n = len.length;
        int[][] t = new int[n + 1][W + 1];
        System.out.println(rodCutting(len, val, W, n, t));
    }
}
