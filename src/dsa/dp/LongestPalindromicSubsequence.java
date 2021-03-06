package dsa.dp;

/*
Gives length of longest palindromic subsequence
 */
public class LongestPalindromicSubsequence {

    static int lcs(char[] a, int m, char[] b, int n) {
        int[][] t = new int[m+1][n+1];
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n ; j++) {
                if(a[i-1] == b[j-1]) {
                    t[i][j] = 1+ t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s1 = "agbcba";
        sb.append(s1);
        String reverseS1 = String.valueOf(sb.reverse());
        char[] a = s1.toCharArray();
        char[] b = reverseS1.toCharArray();
        int lcs = lcs(a, a.length, b, b.length);
        System.out.println(lcs);
    }
}
