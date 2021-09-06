package leetcode_top100;

public class LongestPalindromicSubstring_5 {

    // 使用了java的join操作，耗时较长
    public String longestPalindrome(String s) {
        String res = "";
        String[] strs = s.split("");
        s = String.join(".", strs);
        for (int i = 0; i < s.length(); i++) {
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }
            String temp = String.join("", s.substring(low + 1, high).split("\\."));
            if (res.length() < temp.length()) {
                res = temp;
            }
        }
        System.out.println(res);
        strs = res.split("\\.");
        res = String.join("", strs);
        return res;
    }


    // 其他解法
    public String longestPalindrome2(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //StringBuffer sb = new StringBuffer();
            //sb.append(s.charAt[i]);
            char c = s.charAt(i);
            int left = i;
            int right = i;

            // 下面两个循环是考虑了双数回文字串的情况，就不用插入了
            while (left >= 0 && s.charAt(left) == c) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == c) {
                right++;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }


            // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return s.substring(start, end);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring_5 offer = new LongestPalindromicSubstring_5();
        String str = "";
        String res = offer.longestPalindrome(str);
        System.out.println(res);
    }

}
