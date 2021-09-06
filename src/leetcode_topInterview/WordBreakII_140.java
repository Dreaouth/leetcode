package leetcode_topInterview;

import java.util.*;

public class WordBreakII_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        if (!isWordBreak(s, wordDict)) {
            return res;
        }
        backTracking(res, new StringBuilder(), 0, s, wordDict);
        return res;
    }



    public void backTracking(List<String> totalList, StringBuilder temp, int start, String s, List<String> wordDict) {
        if (start == s.length()) {
            totalList.add(temp.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tempStr = s.substring(start, i + 1);
            int size = tempStr.length();
            if (wordDict.contains(tempStr)) {
                temp.append(tempStr);
                if (i != s.length() - 1) {
                    temp.append(" ");
                    size++;
                }
                backTracking(totalList, temp, i + 1, s, wordDict);
                temp.delete(temp.length() - size, temp.length());
            }
        }
    }


    public boolean isWordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // dp数组表示从第一个字符到第i个字符是否可以切分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreakII_140 offer = new WordBreakII_140();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> res = offer.wordBreak("catsanddog", wordDict);
        System.out.println(res);
    }
}
