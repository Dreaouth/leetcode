package leetcode_top100;

public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        int end = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            end = Math.max(end + nums[i], nums[i]);
            max = Math.max(max, end);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray_53 offer = new MaximumSubarray_53();
        int[] nums = {-2147483647};
        int res = offer.maxSubArray(nums);
        System.out.println(res);
    }
}
