package leetcode_top100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CoinChange_322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MIN_VALUE || dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 offer = new CoinChange_322();
        int[] coins = {2};
        int res = offer.coinChange(coins, 4);
        System.out.println(res);
    }

}
