package leetcode_dp;

public class ProfitableSchemes_879 {


    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int MOD = 1_000_000_007;
        // dp[i][j]表示利润为i，使用工人为j时，有多少种计划可以选择
        int [][]dp = new int[minProfit + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < group.length; i++) {
            for (int j = minProfit; j >= 0; j--) {
                for (int k = n; k >= group[i]; k--) {
                    dp[j][k] += dp[Math.max(j - profit[i], 0)][k - group[i]];
                    dp[j][k] %= MOD;
                }
            }
        }

        return dp[minProfit][n];
    }


    public static void main(String[] args) {
        ProfitableSchemes_879 offer = new ProfitableSchemes_879();
        int[] group = {2,3,5};
        int[] profit = {6,7,8};
        int res = offer.profitableSchemes(10, 5, group, profit);
        System.out.println(res);
    }
}
