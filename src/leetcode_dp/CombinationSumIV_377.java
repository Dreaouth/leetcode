package leetcode_dp;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CombinationSumIV_377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        System.out.println(Arrays.stream(dp).boxed().collect(Collectors.toList()));
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV_377 offer = new CombinationSumIV_377();
        int[] nums = {1, 2, 3};
        int res = offer.combinationSum4(nums, 4);
        System.out.println(res);
    }
}
