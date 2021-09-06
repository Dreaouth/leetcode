package leetcode_top100;

import java.util.Arrays;
import java.util.stream.Collectors;

// 下一个全排列
public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i >= 1 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
           reverse(nums, 0, nums.length - 1);
        } else {
            int larger = nums.length - 1;
            while (larger >= i && nums[larger] <= nums[i - 1]) {
                larger--;
            }
            swap(nums, i - 1, larger);
            reverse(nums, i, nums.length - 1);
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        NextPermutation_31 offer = new NextPermutation_31();
        int[] nums = {1,5,1};
        offer.nextPermutation(nums);
    }
}
