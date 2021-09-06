package leetcode_dp;

import java.util.Arrays;

public class OnesAndZeroes_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int []one = new int[strs.length];
        int []zero = new int[strs.length];
        int [][]dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '1') {
                    one[i]++;
                } else if (strs[i].charAt(j) == '0') {
                    zero[i]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= zero[i]; j--) {
                for (int k = n; k >= one[i]; k--) {
                    //System.out.println(dp[j - zero[i]][k - one[i]]);
                    if (dp[j - zero[i]][k - one[i]] != Integer.MIN_VALUE) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zero[i]][k - one[i]] + 1);
                        max = Math.max(max, dp[j][k]);
                    }
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }

    public static void main(String[] args) {
        OnesAndZeroes_474 offer = new OnesAndZeroes_474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int res = offer.findMaxForm(strs, 5, 3);
        System.out.println(res);
    }
}
