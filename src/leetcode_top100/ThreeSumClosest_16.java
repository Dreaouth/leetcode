package leetcode_top100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3) {
            return 0;
        }
        Arrays.sort(nums);
        int closest = Math.abs(nums[0] + nums[1] + nums[2]);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            // 去重操作
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int total = nums[left] + nums[right] + nums[i];
                if (Math.abs(total - target) < Math.abs(closest - target)) {
                    closest = total;
                }
                if (total == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重操作，跳过重复的
                    return 0;
                } else if (total < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {

    }
}
