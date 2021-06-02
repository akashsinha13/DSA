package dsa.stack;

import java.util.ArrayList;
import java.util.Arrays;
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
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            c = 1;
            if (i == 0) {
                list.add(c);
            } else if (!s.isEmpty() && arr[i] < s.peek()) {
                list.add(c);
            } else if (!s.isEmpty() && arr[i] >= s.peek()) {

                while (!s.isEmpty() && arr[i] >= s.peek()) {
                    temp.push(arr[i]);
                    s.pop();
                    c++;
                }
                list.add(c);

                //populate back to original stack
                while (!temp.isEmpty()) {
                    s.push(temp.pop());
                }
            }
            s.push(arr[i]);
        }
    }

    static void stockSpanProblem2(int[] arr, int n, int[] indexArray) {
        Stack<ArrayContainer> st = new Stack<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                indexArray[j++] = -1;
            } else if (!st.isEmpty() && st.peek().num > arr[i]) {
                indexArray[j++] = st.peek().index;
            } else if (!st.isEmpty() && st.peek().num <= arr[i]) {
                while (!st.isEmpty() && st.peek().num <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    indexArray[j++] = -1;
                } else {
                    indexArray[j++] = st.peek().index;
                }
            }
            st.push(new ArrayContainer(arr[i], i));
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        List<Integer> list = new ArrayList<>();
        int[] indexArray = new int[arr.length];
        int[] ans = new int[arr.length];
        //stockSpanProblem(arr, arr.length, list);
        //System.out.println(list.toString());
        stockSpanProblem2(arr, arr.length, indexArray);
        //System.out.println(Arrays.toString(indexArray));
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i - indexArray[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}

class ArrayContainer {
    int num;
    int index;

    ArrayContainer(int num, int index) {
        this.num = num;
        this.index = index;
    }
}
