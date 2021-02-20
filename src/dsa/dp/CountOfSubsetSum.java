package dsa.dp;

/*
Count of subset sum top down implementation
 */
public class CountOfSubsetSum {
    static int countOfSubsetSum(int[] arr, int sum, int n, int[][] t) {
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
        int[] arr = new int[]{3, 3, 3, 3};
        int sum = 6;
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];
        System.out.println(countOfSubsetSum(arr,sum,n,t));
    }
}
