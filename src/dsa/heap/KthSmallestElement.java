package dsa.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    private  static void kthSmallestElement(int[] arr, int k, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new CustomComparator());
        for(int i=0 ; i< n; i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println("Kth smallest element is: "+ pq.peek());
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 20, 10, 7, 1};
        int k = 2;
        kthSmallestElement(arr, k, arr.length);
    }
}

class CustomComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        int value = a.compareTo(b);
        if(value > 0) {
            return -1;
        } else if(value < 0) {
            return 1;
        }
        return 0;
    }
}
