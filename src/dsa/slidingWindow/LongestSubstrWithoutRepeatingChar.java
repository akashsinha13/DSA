package dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Find length of longest substring without repeating characters
 */
public class LongestSubstrWithoutRepeatingChar {
    public static int longestSubstringWithoutRepeatingChars(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        int i = 0, j = 0;
        int max = 0;
        while (j < charArray.length) {
            map.put(charArray[j], map.getOrDefault(charArray[j], 0) + 1);
            if (map.size() == j-i+1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (map.size() < j-i+1) {
                    if (map.get(charArray[i]) == 1) {
                        map.remove(charArray[i]);
                    } else {
                        map.put(charArray[i], map.get(charArray[i]) - 1);
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkewqaaz";
        System.out.println(longestSubstringWithoutRepeatingChars(str));
    }
}

