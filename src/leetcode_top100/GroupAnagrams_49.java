package leetcode_top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49. Group Anagrams（*）
public class GroupAnagrams_49 {

    // 哈希法
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = new char[26];
            for (char c : strs[i].toCharArray()) {
                str[c - 'a']++;
            }
            String key = String.valueOf(str);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 offer = new GroupAnagrams_49();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = offer.groupAnagrams(strs);
        System.out.println(res);
    }
}
