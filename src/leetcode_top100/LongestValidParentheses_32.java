package leetcode_top100;

import java.util.Stack;

//32. Longest Valid Parentheses(**)
public class LongestValidParentheses_32 {

    // DP + stack
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int max = 0;
        int left = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    // 出栈并配对后更新max，分为 栈中有元素 和 栈中无元素 情况
                    if (stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 offer = new LongestValidParentheses_32();
        int res = offer.longestValidParentheses("(()())))))))((((((");
        System.out.println(res);
    }
}
