package leetcode_dp;

public class PartitionEqualSubsetSum_416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean []dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) dp[j] = true;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[sum / 2];
    }

}
