package dsa.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
Find the next largest number
 */
public class NextLargestElement {
    public static void nextLargestNumber(int[] arr, int n, List<Integer> list) {
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                list.add(-1);
            } else if (!s.isEmpty() && s.peek() > arr[i]) {
                list.add(s.peek());
            } else if (!s.isEmpty() && s.peek() <= arr[i]) {
                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(s.peek());
                }
            }
            s.push(arr[i]);
        }

        Collections.reverse(list);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        List<Integer> list = new ArrayList<>();
        nextLargestNumber(arr, arr.length, list);
        System.out.println(list.toString());
    }
}
