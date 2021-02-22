package dsa.dp;

/*
LCS topdown implementation
 */
public class LCS_TopDown {

    static int lcs(char[] a, int m, char[] b, int n){
        int[][] t = new int[m+1][n+1];
        for(int i=1 ; i<=m ; i++) {
            for(int j=1; j<=n ; j++){
                if(a[i-1] == b[j-1]){
                    t[i][j] = t[i-1][j-1] + 1;
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        System.out.println(lcs(a, a.length, b, b.length));
    }
}
