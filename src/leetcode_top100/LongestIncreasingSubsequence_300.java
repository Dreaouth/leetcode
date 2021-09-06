package leetcode_top100;

import java.util.Arrays;
import java.util.stream.Collectors;

// 最长递增子序列(**)
public class LongestIncreasingSubsequence_300 {

    // 方法一：dp O(n2)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) max = Math.max(max, dp[j] + 1);
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 方法二：贪心+二分查找 O(nlogn)
    // https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
    public int lengthOfLIS_2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence_300 offer = new LongestIncreasingSubsequence_300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int res = offer.lengthOfLIS(nums);
        System.out.println(res);
    }
}
