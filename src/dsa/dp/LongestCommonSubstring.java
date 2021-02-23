package dsa.dp;

/*
Longest common substring implementation
 */
public class LongestCommonSubstring {

    static int lcs(char[] a, int m, char[] b, int n){
        int[][] t = new int[m+1][n+1];
        int res = 0;
        for(int i=1 ; i<=m ; i++) {
            for(int j=1; j<=n ; j++){
                if(a[i-1] == b[j-1]){
                    t[i][j] = t[i-1][j-1] + 1;
                    res = Math.max(t[i][j], res);
                } else {
                    t[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        System.out.println(lcs(a, a.length, b, b.length));
    }
}
