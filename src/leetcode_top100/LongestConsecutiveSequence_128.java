package leetcode_top100;

import java.util.HashSet;
import java.util.Set;

// 128. Longest Consecutive Sequence(*)
public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int size = 0;
                int temp = nums[i];
                while (set.contains(temp)) {
                    size++;
                    temp++;
                }
                longest = Math.max(longest, size);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 offer = new LongestConsecutiveSequence_128();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int res = offer.longestConsecutive(nums);
        System.out.println(res);
    }
}
