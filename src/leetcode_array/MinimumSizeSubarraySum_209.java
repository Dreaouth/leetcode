package leetcode_array;

public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = -1;
        int min = nums.length + 1;
        int sum = 0;
        while (right < nums.length - 1) {
            if (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            } else {
                right++;
                sum += nums[right];
            }
        }
        while (sum >= target) {
            min = Math.min(min, right - left + 1);
            sum -= nums[left];
            left++;
        }
        return min == (nums.length + 1) ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 offer = new MinimumSizeSubarraySum_209();
        int[] nums = {2};
        int res = offer.minSubArrayLen(3, nums);
        System.out.println(res);
    }
}
