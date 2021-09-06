package leetcode_top100;

// 152. Maximum Product Subarray(*)
public class MaximumProductSubarray_152 {

    // 因为多考虑了负数，所以需要加一个求最小值的元素存储，负负得正
    // 因为遍历过程中不是正就是负，如果是正就在max中携带之前的数字乘积，如果是负就在Min中携带之前的数字乘积
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(temp * nums[i], Math.min(min * nums[i], nums[i]));
            res = Math.max(res, max);
            System.out.println(max + " " + min);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray_152 offer = new MaximumProductSubarray_152();
        int[] nums = {2,3,-2,-4};
        int res = offer.maxProduct(nums);
        System.out.println(res);
    }
}
