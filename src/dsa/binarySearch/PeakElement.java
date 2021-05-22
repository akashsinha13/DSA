package dsa.binarySearch;

/*
Find peak element in almost sorted array
 */
public class PeakElement {
    private static int peak(int[] arr, int l, int r){
        if(l<=r) {
            int mid = l + (r-l)/2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid==arr.length-1 || arr[mid] > arr[mid+1])) {
                return arr[mid];
            } else if(mid > 0 && arr[mid] < arr[mid-1]) {
                return peak(arr, l, mid-1);
            } else if(mid < arr.length-1 && arr[mid] < arr[mid+1]){
                return peak(arr, mid+1, r);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 12, 15, 11};
        System.out.println("Peak element is " + peak(arr, 0, arr.length-1));
    }
}
