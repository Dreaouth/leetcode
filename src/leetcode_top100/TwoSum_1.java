package leetcode_top100;

import java.util.HashMap;

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                System.out.println(res[0] + " " + res[1]);
                return res;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        TwoSum_1 twoSum_1 = new TwoSum_1();
        int[] res = twoSum_1.twoSum(nums, 6);
    }
}
