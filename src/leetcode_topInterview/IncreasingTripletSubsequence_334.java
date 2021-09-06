package leetcode_topInterview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int[] dpFirst = new int[nums.length];
        int[] dpSecond = new int[nums.length];
        Arrays.fill(dpSecond, Integer.MAX_VALUE);
        dpFirst[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpFirst[i] = Math.min(dpFirst[i - 1], nums[i]);
            if (dpSecond[i - 1] == Integer.MAX_VALUE && dpFirst[i] == nums[i]) {
                dpSecond[i] = Integer.MAX_VALUE;
            } else if (dpFirst[i] < nums[i]) {
                dpSecond[i] = Math.min(dpSecond[i - 1], nums[i]);
            } else {
                dpSecond[i] = dpSecond[i - 1];
            }
            if (nums[i] > dpSecond[i - 1]) {
                return true;
            }
            System.out.println(nums[i]);
            System.out.println(Arrays.stream(dpFirst).boxed().collect(Collectors.toList()));
            System.out.println(Arrays.stream(dpSecond).boxed().collect(Collectors.toList()));
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence_334 offer = new IncreasingTripletSubsequence_334();
        int[] nums = {1,2,3};
        boolean res = offer.increasingTriplet(nums);
        System.out.println(res);
    }

}
