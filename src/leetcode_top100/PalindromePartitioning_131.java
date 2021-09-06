package leetcode_top100;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning(**)
public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s, 0);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> tempList, String s, int start) {
        if (start == s.length()) { // 只有遍历到末尾的才会加入result，不形成回文字串的会直接返回
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i+1));
                    dfs(res, tempList, s, i+1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning_131 offer = new PalindromePartitioning_131();
        List<List<String>> res = offer.partition("s");
        System.out.println(res);
    }
}
