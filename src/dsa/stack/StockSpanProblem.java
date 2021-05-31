package dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Find consecutive smaller or equal elements count
 */
public class StockSpanProblem {
    static void stockSpanProblem(int[] arr, int n, List<Integer> list) {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int c;
        if(n == 0) {
            return;
        }

        for(int i=0; i<n; i++) {
            c=1;
            if(i == 0) {
                list.add(c);
            } else if(!s.isEmpty() && arr[i] < s.peek()) {
                list.add(c);
            } else if(!s.isEmpty() && arr[i] >= s.peek()) {

                while(!s.isEmpty() && arr[i] >= s.peek()) {
                    temp.push(arr[i]);
                    s.pop();
                    c++;
                }
                list.add(c);

                //populate back to original stack
                while(!temp.isEmpty()){
                    s.push(temp.pop());
                }
            }
            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,80,60,70,60,75,85};
        List<Integer> list = new ArrayList<>();
        stockSpanProblem(arr, arr.length, list);
        System.out.println(list.toString());
    }
}
