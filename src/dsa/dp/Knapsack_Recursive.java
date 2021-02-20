package dsa.dp;

/*
01 knapsack recursive implementation
 */
public class Knapsack_Recursive {

    static int knapsack(int wt[], int val[], int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }
        // if element weight is less than total weight
        // choices
        // 1. select last element
        // 2. don't select last element
        // take the maximum of either choices
        if(wt[n-1] <= W) {
            return max(val[n-1] + knapsack(wt, val, W- wt[n-1], n-1),
                        knapsack(wt, val, W, n-1));
        } else {
            // if weight is greater, don't select this element
            return knapsack(wt, val, W, n-1);
        }
    }

    static int max(int a, int b) {
        return a>b ? a : b;
    }

    public static void main(String[] args) {
        int[] wt = new int[]{ 10, 20, 30 };
        int[] val = new int[]{ 60, 100, 120 };
        int W = 50;
        int n = wt.length;
        System.out.println(knapsack(wt, val, W, n));
    }
}
