package leetcode_top100;

import java.util.Stack;

// 84. Largest Rectangle in Histogram(***)
public class LargestRectangleInHistogram_84 {

    // 1. 动态规划法：maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
    // lessFromLeft和lessFromRight表示对于高度i当前，其左面可以继续延伸的最大高度和其右面可以延伸的最大高度
    public int largestRectangleArea_dp(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    // 2. 单调栈：进栈时不确定，出栈时就能确定其最大矩形面积：当新看到的元素的高度小于栈顶元素的高度时，就确定了栈顶元素的面积，可以出栈。
    // 计算面积的宽度为当前元素的下标与新栈顶元素的下标相减再减1
    // 特殊情况：当遍历完成后，剩余栈中的元素的宽度一定可以达到数组的末尾
    public int largestRectangleArea_stack(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        } else if (heights.length == 1) {
            return heights[0];
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int len;
                if (stack.isEmpty()) {
                    len = i;
                } else {
                    len = i - stack.peek() - 1;
                }
                res = Math.max(res, height * len);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int len;
            if (stack.isEmpty()) {
                len = heights.length;
            } else {
                len = heights.length - stack.peek() - 1;
            }
            res = Math.max(res, height * len);
        }
        return res;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 offer = new LargestRectangleInHistogram_84();
        int[] height = {2,1,5,6,2,3};
        int res = offer.largestRectangleArea_stack(height);
        System.out.println(res);
    }
}
