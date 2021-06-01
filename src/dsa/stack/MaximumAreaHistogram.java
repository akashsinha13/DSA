package dsa.stack;

import java.util.Stack;

/*
Find the maximum area under histogram
 */
public class MaximumAreaHistogram {
    /*
    Find the left smallest index
     */
    static int[] minLeftIndex(int[] histogram, int n) {
        int pseudoIndex = -1;
        Stack<ArrayContainer> s = new Stack<>();
        int[] arr = new int[histogram.length];
        for(int i=0 ; i<n ; i++) {
            if(s.isEmpty()) {
                arr[i] = pseudoIndex;
            } else if(!s.isEmpty() && s.peek().num >= histogram[i]) {
                while(!s.isEmpty() && s.peek().num >= histogram[i]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    arr[i] = pseudoIndex;
                } else {
                    arr[i] = s.peek().index;
                }
            } else if(!s.isEmpty() && s.peek().num <= histogram[i]) {
                arr[i] = s.peek().index;
            }
            s.push(new ArrayContainer(histogram[i], i));
        }
        return arr;
    }

    /*
    Find the right smallest index
     */
    static int[] minRightIndex(int[] histogram, int n) {
        Stack<ArrayContainer> s = new Stack<>();
        int pseudoIndex = n;
        int[] arr = new int[histogram.length];
        for(int i=n-1; i>=0 ; i--) {
            if(s.isEmpty()) {
                arr[i] = pseudoIndex;
            } else if(!s.isEmpty() && s.peek().num >= histogram[i]) {
                while(!s.isEmpty() && s.peek().num >= histogram[i]) {
                    s.pop();
                }
                if(s.isEmpty()) {
                    arr[i] = pseudoIndex;
                } else {
                    arr[i] = s.peek().index;
                }
            } else if(!s.isEmpty() && s.peek().num < histogram[i]) {
                arr[i] = s.peek().index;
            }

            s.push(new ArrayContainer(histogram[i], i));
        }
        return arr;
    }


    static int maxArea(int[] histogram) {
        int maxArea = Integer.MIN_VALUE;
        int[] minLeftIndex = minLeftIndex(histogram, histogram.length);
        int[] minRightIndex = minRightIndex(histogram, histogram.length);

        for(int i=0 ; i<histogram.length ; i++)  {
            int width = minRightIndex[i] - minLeftIndex[i] - 1;
            int area = width * histogram[i];
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = new int[]{6,7,4,1,4,1,6};
        System.out.println("Maximum area is " + maxArea(histogram));
    }
}

