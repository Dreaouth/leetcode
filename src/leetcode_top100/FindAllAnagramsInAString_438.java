package leetcode_top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString_438 {

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        // count表示p中不重复的所有字符（重点）
        int count = map.size();
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            right++;
            while (count == 0) {
                char c1 = s.charAt(left);
                if (map.containsKey(c1)) {
                    if (map.get(c1) == 0) count++;
                    map.put(c1, map.get(c1) + 1);
                }
                if (right - left == p.length()) {
                    res.add(left);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString_438 offer = new FindAllAnagramsInAString_438();
        List<Integer> res = offer.findAnagrams("abab", "ab");
        System.out.println(res);
    }

}
