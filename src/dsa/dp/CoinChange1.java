package dsa.dp;

/*
Maximum number of ways to sum up a given value
 */
public class CoinChange1 {
    static int coinChange(int[] coins, int len, int sum, int[][] t){
        // initialization
        // if sum = 0, we can have an empty set
        for(int i=0 ; i<=len ; i++) {
            t[i][0] = 1;
        }

        for(int i=1 ; i<=len ; i++){
            for(int j=1 ; j<=sum ; j++){
                if(coins[i-1] <= j) {
                    t[i][j] = (t[i][j - coins[i-1]]) + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[len][sum];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 4;
        int len = coins.length;
        int[][] t = new int[len+1][sum+1];
        System.out.println(coinChange(coins, len, sum, t));
    }
}
