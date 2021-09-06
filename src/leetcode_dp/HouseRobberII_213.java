package leetcode_dp;

public class HouseRobberII_213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(dp(nums, 0, nums.length - 2), dp(nums, 1, nums.length - 1));
        }
    }

    public int dp(int[] nums, int start, int end) {
        int []dp = new int[nums.length + 1];
        dp[start] = 0;
        dp[start + 1] = nums[start];
        int max = nums[start];
        for (int i = start + 1; i <= end; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        HouseRobberII_213 offer = new HouseRobberII_213();
        int []nums = {1, 2, 3, 1};
        int res = offer.rob(nums);
        System.out.println(res);
    }
}
