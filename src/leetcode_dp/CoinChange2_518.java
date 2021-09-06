package leetcode_dp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CoinChange2_518 {

    public int change(int amount, int[] coins) {
        // dp[i]表示凑成总资产为i的硬币组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(Arrays.stream(coins).boxed().collect(Collectors.toList()));
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2_518 offer = new CoinChange2_518();
        int[] coins = {1, 2, 5};
        int res = offer.change(5, coins);
        System.out.println(res);
    }
}
