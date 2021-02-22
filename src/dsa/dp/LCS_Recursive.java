package dsa.dp;

/*
Largest common subsequence implementation
 */
public class LCS_Recursive {

    static int lcs(char[] a, int m, char[] b, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(a[m-1] == b[n-1]) {
            return 1 + lcs(a, m-1, b, n-1);
        } else {
            return max(lcs(a, m, b, n-1), lcs(a, m-1, b, n));
        }
    }

    static int max(int a, int b) {
        return a>b ? a : b;
    }

    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        System.out.println(lcs(a, a.length, b, b.length));
;    }
}
