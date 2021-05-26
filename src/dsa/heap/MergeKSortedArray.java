package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Merge k sorted arrays in O(nlogk) time
 */
public class MergeKSortedArray {
    private static int[] mergeKSortedArray(int[][] arr) {
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();
        int length =0;

        // Add arrays to heap
        for(int i=0 ; i<arr.length ; i++) {
            pq.add(new ArrayContainer(arr[i], 0));
            length += arr[i].length;
        }
        System.out.println(pq);

        int[] result = new int[length];
        int m=0;

        while(pq.size()>0) {
            ArrayContainer temp = pq.poll();
            result[m++] = temp.arr[temp.index];
            if(temp.index < temp.arr.length-1) {
                pq.add(new ArrayContainer(temp.arr, temp.index+1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}

class ArrayContainer implements Comparable<ArrayContainer> {
    int[] arr;
    int index;

    ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    public int compareTo(ArrayContainer obj) {
        return this.arr[this.index] - obj.arr[obj.index];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.arr);
    }
}
