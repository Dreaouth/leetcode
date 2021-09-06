package leetcode_topInterview;

public class LongestSubstringWithAtLeastKRepeatingCharacters_395 {

    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || k > s.length()) {
            return 0;
        } else if (k < 2) {
            return s.length();
        }
        return count(s.toCharArray(), k, 0, s.length() - 1);
    }

    private int count(char[] strs, int k, int start, int end) {
        if (end - start + 1 < k) return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[strs[i] - 'a']++;
        }
        while (end - start + 1 >= k && count[strs[end] - 'a'] < k) {
            end--;
        }
        while (end - start + 1 >= k && count[strs[start] - 'a'] < k) {
            start++;
        }
        if (end - start + 1 < k) return 0;
        for (int i = start; i <= end; i++) {
            if (count[strs[i] - 'a'] < k) {
                return Math.max(count(strs, k, start, i - 1), count(strs, k ,i + 1, end));
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingCharacters_395 offer = new LongestSubstringWithAtLeastKRepeatingCharacters_395();
        int res = offer.longestSubstring("ababacb", 3);
        System.out.println(res);
    }

}
