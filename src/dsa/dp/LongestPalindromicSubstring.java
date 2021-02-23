package dsa.dp;

/*
Gives length of longest palindromic substring
 */
public class LongestPalindromicSubstring {

    static int lcs(char[] a, int m, char[] b, int n) {
        int[][] t = new int[m+1][n+1];
        int res = 0;
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n ; j++) {
                if(a[i-1] == b[j-1]) {
                    t[i][j] = 1+ t[i-1][j-1];
                    res = Math.max(res, t[i][j]);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return res;
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