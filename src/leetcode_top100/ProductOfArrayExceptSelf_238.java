package leetcode_top100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf_238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int[] resNums = new int[nums.length];
        resNums[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            resNums[i] = resNums[i + 1] * nums[i + 1];
        }
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            resNums[i] = resNums[i] * temp;
            temp *= nums[i];
        }
        return resNums;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 offer = new ProductOfArrayExceptSelf_238();
        int[] nums = {1,2,3,4};
        int[] res = offer.productExceptSelf(nums);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
