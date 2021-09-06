package leetcode_top100;

public class HouseRobber_198 {

    // 这类题型，两种状态：此处偷了财产和此处没有偷财产
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) dp[i] = dp[i - 2] + nums[i];
            else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        return memo[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber_198 offer = new HouseRobber_198();
        int[] nums = {100,3,5,10000,90};
        int res = offer.rob2(nums);
        System.out.println(res);
    }
}
