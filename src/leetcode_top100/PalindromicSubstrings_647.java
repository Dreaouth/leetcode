package leetcode_top100;

public class PalindromicSubstrings_647 {

    int ans = 0;

    // dp法比较麻烦，还是用扩展法吧
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return ans;
    }

    public void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            System.out.println("h");
            left--;
            right++;
            ans++;
        }
    }

    // dp法，需要了解！！！！
    public int countSubstrings_dp(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i  + 1 < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PalindromicSubstrings_647 offer = new PalindromicSubstrings_647();
        int res = offer.countSubstrings("aaa");
        System.out.println(res);
    }
}
