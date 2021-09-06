package offer;

// 剪绳子（***）
public class Offer67 {

    // 动态规划法：dp[i]表示的是长度为i的绳子能得到的最大乘积
    // dp[i] = max['i选择不剪', max(‘左边选择不剪’, ‘左边继续剪’) * max(‘右边选择不剪’, ‘右边继续剪’)]
    // 即，max[dp[i], max(j, dp[j]) * max(i-j, dp[i-j])]
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
