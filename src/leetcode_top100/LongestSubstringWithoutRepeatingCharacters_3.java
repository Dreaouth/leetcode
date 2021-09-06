package leetcode_top100;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int lastSub = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= lastSub) {
                System.out.println(s.charAt(i));
                int temp = map.get(s.charAt(i));
                while (temp < i && s.charAt(temp) == s.charAt(i)) {
                    temp++;
                }
                lastSub = temp;
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - lastSub + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 offer = new LongestSubstringWithoutRepeatingCharacters_3();
        int res = offer.lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }
}
