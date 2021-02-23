package dsa.dp;

import java.util.Stack;

public class LCS_Print {
    static void lcs(char[] a, int m, char[] b, int n, int[][] t) {
        for(int i=1 ; i<=m ; i++) {
            for(int j=1; j<=n ; j++){
                if(a[i-1] == b[j-1]){
                    t[i][j] = t[i-1][j-1] + 1;
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "akash";
        String s2 = "ashish";
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[][] t = new int[a.length+1][b.length+1];
        lcs(a, a.length, b, b.length, t);

        // print
        int i = a.length;
        int j = b.length;
        Stack s = new Stack();

        while(i>0 && j>0) {
            if(a[i-1]==b[j-1]){
                s.push(a[i-1]);
                i--;
                j--;
            }
            else if(t[i-1][j] > t[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop() + "");
        }
    }
}
