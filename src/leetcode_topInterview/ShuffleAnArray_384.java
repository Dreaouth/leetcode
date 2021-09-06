package leetcode_topInterview;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray_384 {

    // 洗牌算法
    class Solution {

        int[] originNums;
        int[] shuffleNums;
        Random random;

        public Solution(int[] nums) {
            random = new Random();
            shuffleNums = nums;
            originNums = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return originNums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for (int i = 0; i < shuffleNums.length; i++) {
                int index = random.nextInt(shuffleNums.length);
                swap(shuffleNums, i, index);
            }
            return shuffleNums;
        }

        public void swap(int[] nums, int start, int end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

}
