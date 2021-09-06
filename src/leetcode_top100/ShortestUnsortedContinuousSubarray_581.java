package leetcode_top100;

public class ShortestUnsortedContinuousSubarray_581 {

    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                max = Math.max(max, nums[i-1]);
                min = Math.min(min, nums[i]);
                if (left == -1) {
                    left = i - 1;
                    right = i;
                } else {
                    right = i;
                }
            }
        }
        if (left == -1) {
            return 0;
        }
        System.out.println(min + " " + max);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] < max) {
                right = j;
                break;
            }
        }
        return (right - left + 1);
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray_581 offer = new ShortestUnsortedContinuousSubarray_581();
        int[] nums = {2,6,4,8,10,9,15};
        int res = offer.findUnsortedSubarray(nums);
        System.out.println(res);
    }

}
