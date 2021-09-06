package leetcode_top100;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            // 注意是从后往前
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
            for (boolean f : dp) {
                System.out.print(f + " ");
            }
            System.out.println();
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum_416 offer = new PartitionEqualSubsetSum_416();
        int[] nums = {2,2,3,5};
        boolean res = offer.canPartition(nums);
        System.out.println(res);
    }
}
