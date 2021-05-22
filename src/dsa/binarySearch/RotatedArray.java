package dsa.binarySearch;

/*
Find element in rotated sorted array
 */
public class RotatedArray {
    private static int alteredBinarySearch(int[] arr, int l, int r, int key) {
        if(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == key) {
                return mid;
            }

            if(arr[l] <= arr[mid]) { // if left half is sorted
                if(arr[l] <= key && key <= arr[mid]) {
                    // if element lies in left half
                   return alteredBinarySearch(arr, l, mid-1, key);
                }
                // element lies in right half
                 return alteredBinarySearch(arr, mid+1, r, key);
            }

            if(arr[r] >= arr[mid]) { // if right half is sorted
                if(key>= arr[mid] && key<= arr[r]) {
                    // if element lies in right half
                     return alteredBinarySearch(arr, mid+1, r, key);
                }
                // if element lies in left half
                return alteredBinarySearch(arr, l, mid-1, key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;
        System.out.println("Element found at index: " +
                alteredBinarySearch(arr, 0 , arr.length-1, key));
    }
}
