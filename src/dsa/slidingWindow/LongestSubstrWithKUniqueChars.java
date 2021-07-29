package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
    Find the longest substring with k unique characters
 */
public class LongestSubstrWithKUniqueChars {

    public static int longestSubstringWithUniqueChars(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while (j < charArray.length) {
            map.put(charArray[j], map.getOrDefault(charArray[j], 0) + 1);
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() > k) {
                    if (map.get(charArray[i]) == 1) {
                        map.remove(charArray[i]);
                    } else {
                        map.put(charArray[i], map.get(charArray[i]) - 1);
                    }
                    i++;
                }
//                if(map.size() == k) {
//                    max = Math.max(max, j-i+1);
//                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstringWithUniqueChars(str, k));
    }
}
