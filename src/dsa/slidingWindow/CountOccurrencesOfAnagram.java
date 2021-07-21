package dsa.slidingWindow;

import java.util.Arrays;

/*
    Find the total number of occurrences of Anagram
 */
public class CountOccurrencesOfAnagram {

    private static int countOccurrences(String str, String ptr) {
        int count = 0;
        int i=0, j=0;
        StringBuilder sb= new StringBuilder();
        char[] ptrArray = ptr.toCharArray();
        Arrays.sort(ptrArray);
        while(j< str.length()) {
            sb.append(str.charAt(j));
            if(j-i+1 < ptr.length()) {
                j++;
            }
            else if(j-i+1 == ptr.length()) {
                if(compare(sb.toString(), ptrArray)) {
                    count++;
                }
                sb.deleteCharAt(0);
                i++;
                j++;
            }
        }
        return count;
    }

    public static boolean compare(String str, char[] ptr) {
        char[] strArray = str.toCharArray();
        Arrays.sort(strArray);
        return Arrays.equals(strArray, ptr);
    }

    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String ptr = "for";
        System.out.println(countOccurrences(str, ptr));
    }
}
