package leetcode_top100;

public class HouseRobberII_213 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }

    public int rob1(int[] nums, int start, int end) {
        int[] memo = new int[nums.length + 1];
        memo[start] = 0;
        memo[start + 1] = nums[start];
        for (int i = start+1; i < end; i++) {
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        return memo[nums.length];
    }

    public static void main(String[] args) {

    }
}
