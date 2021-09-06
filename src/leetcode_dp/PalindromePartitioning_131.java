package leetcode_dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean [][]dp = new boolean[s.length()][s.length()];
        backtracking(res, new ArrayList<>(), s, dp, 0);
        return res;
    }

    public void backtracking(List<List<String>> res, List<String> tempList, String s, boolean[][] dp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, dp, start, i)) {
                tempList.add(s.substring(start, i + 1));
                dp[start][i] = true;
                backtracking(res, tempList, s, dp, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, boolean[][] dp, int start, int end) {
        if (start == end) {
            return true;
        } else {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }



    public static void main(String[] args) {
        PalindromePartitioning_131 offer = new PalindromePartitioning_131();
        List<List<String>> res = offer.partition("a");
        System.out.println(res);
    }
}
