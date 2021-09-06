package leetcode_top100;

import java.util.HashMap;

// 76. Minimum Window Substring(**)
public class MinimumWindowSubstring_76 {

    // 双指针滑动窗口 + hashmap
    public String minWindow(String s, String t) {
        // map中元素初始时是t中每个字符的大小，每当遍历s中有的字符就进行减一，可以减到负数（因为可能超出），即判断其<=0就表示它装满了
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // count表示hashmap中的元素是否等于t.length，满了就不再增加，但会继续存储到map中
        int count = 0;
        int min = s.length() + 1;
        int minLeft = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            System.out.println(left + " " + s.charAt(left) + " " + right + " " + s.charAt(right) + " " + count);
            if (count < t.length()) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    System.out.println("in" + c + " " + map.get(c));
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) >= 0) count++;
                }
                if (count < t.length()) {
                    right++;
                }
            } else if (count == t.length()){ //只有当count == t.length时
                char c = s.charAt(left);
                if ((right - left + 1) < min) {
                    min = (right - left + 1);
                    minLeft = left;
                }
                if (map.containsKey(c)) {
                    System.out.println(c + " " + map.get(c));
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count--;
                        right++;
                    }
                }
                left++;
            } else {
                System.out.println("not happened");
            }
        }
        if (min > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + min);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring_76 offer = new MinimumWindowSubstring_76();
        String res = offer.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}
