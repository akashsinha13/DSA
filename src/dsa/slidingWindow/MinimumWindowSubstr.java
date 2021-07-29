package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Find the smallest window in a string containing all characters of another string
 */
public class MinimumWindowSubstr {

    public static int minWindowSubstr(String str, String ptr) {
        Map<Character, Integer> ptrMap = new HashMap<>();
        for(int i=0; i<ptr.length(); i++) {
            ptrMap.put(ptr.charAt(i), ptrMap.getOrDefault(ptr.charAt(i), 0) + 1);
        }
        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        int count = ptrMap.size();

        while(j< str.length()) {
           if(ptrMap.containsKey(str.charAt(j))) {
               if(ptrMap.get(str.charAt(j)) == 1) {
                   count--;
               }
               ptrMap.put(str.charAt(j), ptrMap.get(str.charAt(j)) - 1);
           }
           if(count == 0) {
               while(count == 0) {
                   if(ptrMap.containsKey(str.charAt(i))) {
                       if(ptrMap.get(str.charAt(i))< 0) { // we have extra same element
                           ptrMap.put(str.charAt(i), ptrMap.get(str.charAt(i)) + 1);
                           i++;
                       } else {
                           break;
                       }
                   } else {
                       i++; // this element is not required
                   }
               }
               min = Math.min(min, j-i+1);
           }
           j++;
        }
        return min;
    }

    public static void main(String[] args) {
        String str = "aoctxooooaoycto";
        String ptr = "toc";
        System.out.println(minWindowSubstr(str, ptr));
    }
}
