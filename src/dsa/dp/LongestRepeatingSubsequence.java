package dsa.dp;

public class LongestRepeatingSubsequence {

    static int lrs(char[] a, int m, char[] b, int n) {
        int[][] t = new int[m+1][n+1];
        for(int i=1; i<=m ; i++){
            for(int j=1; j<=n ; j++) {
                if(a[i-1] == b[j-1] && i!=j) {
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
        String s1 = "axxxy";
        sb.append(s1);
        String reverseS1 = String.valueOf(sb.reverse());
        char[] a = s1.toCharArray();
        char[] b = reverseS1.toCharArray();
        int lrs = lrs(a, a.length, b, b.length);
        System.out.println(lrs);
    }
}
