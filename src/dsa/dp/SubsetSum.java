package dsa.dp;

/*
subset sum top down implementation
 */
public class SubsetSum {

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
        int[] arr = new int[]{3, 12, 5, 2};
        int sum = 7;
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        System.out.println(subsetSum(arr,sum,n,t));
    }
}
