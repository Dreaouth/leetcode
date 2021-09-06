package leetcode_top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[j] + nums[i] == target) {
                        res.add(Arrays.asList(nums[left], nums[right], nums[j], nums[i]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] + nums[j] + nums[i] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> res = fourSum_18.fourSum(nums, 0);
        System.out.println(res);
    }
}
