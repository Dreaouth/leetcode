package leetcode_top100;


import java.util.Arrays;
import java.util.stream.Collectors;

public class MoveZeroes_283 {

    // 双指针法
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int zero = 0, notZero = 0;
        while (notZero < nums.length) {
            while (notZero < nums.length && nums[notZero] == 0) {
                notZero++;
            }
            while (zero < nums.length && nums[zero] != 0) {
                zero++;
            }
            if (zero == nums.length || notZero == nums.length) {
                break;
            }
            if (notZero > zero) {
                swap(nums, zero, notZero);
                zero++;
                notZero++;
            } else {
                notZero++;
            }
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        MoveZeroes_283 offer = new MoveZeroes_283();
        int[] nums = {1,0};
        offer.moveZeroes(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
