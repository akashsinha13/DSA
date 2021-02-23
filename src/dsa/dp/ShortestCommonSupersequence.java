package dsa.dp;

public class ShortestCommonSupersequence {

    static int lcs(char[] a, int m, char[] b, int n) {
        int[][] t = new int[m+1][n+1];
        for(int i=1 ; i<=m ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(a[i-1] == b[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }

    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int lcs = lcs(a, a.length, b, b.length);
        int scs = a.length + b.length - lcs;
        System.out.println(scs);
    }
}
