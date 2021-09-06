package leetcode_top100;

import java.util.LinkedList;
import java.util.List;

// 22. Generate Parentheses(*)
public class GenerateParentheses_22 {

    // 回溯法（类似全排列），不使用栈，而是在dfs参数中分别指定两种括号的数量
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String str, int left, int right, int n) {
        if (str.length() == n*2) {
            res.add(str);
            return;
        }
        // 注意两个判断
        if (left < n) {
            backtrack(res, str + '(', left+1, right, n);
        }
        if (right < left) {
            backtrack(res, str + ')', left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses_22 offer = new GenerateParentheses_22();
        List<String> res = offer.generateParenthesis(3);
        System.out.println(res);
    }

}
