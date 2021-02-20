package dsa.dp;
/*
Minimum number of coins to reach given sum
 */
public class CoinChange2 {
    static int coinChange(int[] coins, int len, int sum, int[][] t){
        // initialization
        // we are taking max -1 because
        // we are adding 1 on coin selection
        // to avoid overflow
        int max = Integer.MAX_VALUE - 1;
        // if no coins are present and we need to reach some sum
        // and ask for minimum number of it, we usually initialize
        // it with max value
        for(int j=0 ; j<=sum ; j++)
            t[0][j] = max;
        // minimum number of coins to reach sum 0 is 0
        // we don't need any coins to reach sum 0
        for(int i=0 ; i<=len ; i++)
            t[i][0] = 0;
        // we need to initialize 2nd row also
        // consider this as an exception
        for(int j=1 ; j<=sum; j++){
            if(j%coins[0]==0){
                t[1][j] = j/coins[0];
            }else {
                t[1][j] = max;
            }
        }

        for(int i=1 ; i<=len ; i++){
            for(int j=1 ; j<=sum ; j++){
                if(coins[i-1] <= j) {
                    t[i][j] = min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[len][sum];
    }

    static int min(int a, int b) {
        return a>b ? b : a;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{9, 6, 5, 1};
        int sum = 11;
        int len = coins.length;
        int[][] t = new int[len+1][sum+1];
        System.out.println(coinChange(coins, len, sum, t));
    }
}
