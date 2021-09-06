package leetcode_top100;

import java.util.HashMap;
import java.util.Map;

// 560. Subarray Sum Equals K(**)
public class SubarraySumEqualsK_560 {

    //滑动窗口不适用于数组中有负数的情况*****，所以需要使用前缀和+哈希表优化法
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int[] pre = new int[nums.length + 1];
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
            if (map.containsKey(pre[i+1] - k)) {
                // 相当于也加上了之前的
                count += map.get(pre[i+1] - k);
            }
            map.put(pre[i+1], map.getOrDefault(pre[i+1], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 offer = new SubarraySumEqualsK_560();
        int[] nums = {1,1,1};
        int res = offer.subarraySum(nums, 2);
        System.out.println(res);
    }

}
