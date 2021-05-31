package dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Find the previous largest element
 */
public class PreviousLargestElement {
    public static void previousLargestNumber(int[] arr, int n, List<Integer> list) {
        Stack<Integer> s = new Stack<>();
        for(int i=0 ; i<n ; i++) {
            if(s.isEmpty()) {
                list.add(-1);
            } else if(!s.isEmpty() && s.peek() > arr[i]) {
                list.add(s.peek());
            } else if(!s.isEmpty() && s.peek() <= arr[i]) {
                while(!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(s.peek());
                }
            }
            s.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 4};
        List<Integer> list = new ArrayList<>();
        previousLargestNumber(arr, arr.length, list);
        System.out.println(list.toString());
    }
}
