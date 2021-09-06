package leetcode_top100;

public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, 0, S);
    }

    public int dfs(int[] nums, int start, int target) {
        if (start == nums.length) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(nums, start + 1, target - nums[start]) + dfs(nums, start + 1, target + nums[start]);
    }

    // 动态规划方法
    // dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
    public int findTargetSumWays_dp(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }


    public static void main(String[] args) {
        TargetSum_494 offer = new TargetSum_494();
        int[] nums = {1, 1, 1, 1, 1};
        int res = offer.findTargetSumWays(nums, 3);
        System.out.println(res);
    }

}
