package dsa.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Sort the kth sorted array/ nearly sorted array on nlogk time
 */
public class NearlySortedArray {
    private static void kthSortedArray(int[] arr, int n, int k, ArrayList<Integer> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
            if(pq.size() > k) {
                list.add(pq.poll());
            }
        }
        while(pq.size()>0) {
            list.add(pq.poll());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{20, 6, 3, 12, 56, 8};
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        int n = arr.length;
        int k=3;
        kthSortedArray(arr, n, k, list);
        System.out.println(list.toString());
    }
}
