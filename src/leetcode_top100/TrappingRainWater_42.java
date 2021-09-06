package leetcode_top100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TrappingRainWater_42 {

    // 按照每列计算雨水值大小，min_height=min(max_right,max_left)
    // 动态规划法：先遍历两遍分别技术left_max和right_max，时间复杂度O(n)，空间复杂度O(n)
    public int trap_dp(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        maxRight[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        System.out.println(Arrays.stream(maxLeft).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(maxRight).boxed().collect(Collectors.toList()));
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            if (minHeight > height[i]) {
                maxArea += (minHeight - height[i]);
            }
        }
        return maxArea;
    }

    // 双指针法：由于前面已经知道积水的高度是由较低的那边决定的，那么可以考虑双指针法，当左边指针高度小于右边时，计算左边的积水体积，并将指针left右移，
    // 当左边指针高度大于右边时，再移动右边。时间复杂度O(n)，空间复杂度O(n)
    public int trap_doublePtr(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxLeft = 0, maxRight = 0;
        int left = 0, right = height.length - 1;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < maxLeft) {
                    sum += (maxLeft - height[left]);
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    sum += (maxRight - height[right]);
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater_42 offer = new TrappingRainWater_42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = offer.trap_doublePtr(height);
        System.out.println(res);
    }
}
