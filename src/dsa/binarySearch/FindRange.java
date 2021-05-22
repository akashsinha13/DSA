package dsa.binarySearch;
/*
Find the leftmost and rightmost index of a given element in sorted array
 */
public class FindRange {
    private static void findRange(int[] arr, int l, int r, int key) {
        int left = alteredBinarySearch(arr, l, r, key, true);
        int right = alteredBinarySearch(arr, l, r, key, false);
        System.out.println("Left index: "+ left + " and Right index: "+ right);
    }

    private static int alteredBinarySearch(int[] arr, int l, int r, int key, boolean isLeft) {
        int res = -1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(arr[mid] == key) {
                res = mid;
                if(isLeft) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            } else if(arr[mid]>key) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,4,4,4,7,8,11,13,19,23,34,45};
        int key = 4;
        findRange(arr, 0, arr.length-1, key);
    }

}
