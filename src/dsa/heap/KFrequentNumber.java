package dsa.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Find k numbers with max frequency
 */
public class KFrequentNumber {
    private static void kFrequentNumber(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq;
        pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                }
        );

        for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
            pq.add(mp);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        System.out.println(k+ " numbers with max frequency");
        while(pq.size()>0) {
            System.out.println(pq.poll().getKey());
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 3, 1, 4, 4, 4, 5, 2, 6, 1};
        int n = arr.length;
        int k=2;
        kFrequentNumber(arr, n, k);
    }
}
