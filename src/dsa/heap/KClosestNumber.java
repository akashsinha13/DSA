package dsa.heap;

import java.util.PriorityQueue;

/*
Find the k closest Number
 */
public class KClosestNumber {
    private static void kClosestNumber(int[] arr, int n, int k, int num) {
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.add(new Temp(arr[i], Math.abs(arr[i]-num)));
            if(pq.size()>k) {
                pq.poll();
            }
        }
        System.out.println("K closest numbers are: ");
        while(pq.size()>0) {
            System.out.println(pq.poll().num);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,7,8,3,9,11,12};
        int len = arr.length;
        int k = 3;
        int num = 10;
        kClosestNumber(arr, len, k, num);
    }
}

class Temp implements Comparable<Temp> {
    int num;
    int diff;

    Temp(int num, int diff) {
        this.num = num;
        this.diff = diff;
    }

    public int compareTo(Temp b) {
        return b.diff - this.diff;
    }
}
