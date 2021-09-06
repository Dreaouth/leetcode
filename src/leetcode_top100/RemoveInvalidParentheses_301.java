package leetcode_top100;

import java.util.LinkedList;
import java.util.List;

// 301. Remove Invalid Parentheses(***)
public class RemoveInvalidParentheses_301 {

    public List<String> removeInvalidParentheses(String s) {
        // 首先，判断需要删除多少个左括号和右括号
        int l = 0;
        int r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            if (c == ')' && l == 0) r++;
            else if (c == ')') l--;
        }
        List<String> res = new LinkedList<>();
        // 根据需要删除的左括号和右括号个数进行递归
        dfs(s, 0, l, r, res);
        return res;
    }

    public boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public void dfs(String s, int start, int l, int r, List<String> res) {
        if (l == 0 && r == 0 && isValid(s)) {
            res.add(s);
        }
        //这种dfs方式判断要删除的左右括号可能会导致重复，可以使用一个hashmap，最后再将hashmap转化为list
        //但有一种更好的方法：即当遍历到连续多个相同的左/右括号时，只删除其中的一个（这里只删除第一个）就避免了重复
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String left = s.substring(0, i);
                String right = s.substring(i + 1);
                String curr = left + right;
                if (r > 0) dfs(curr, i, l, r - 1, res);
                else if (l > 0) dfs(curr, i, l - 1, r, res);
            }
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses_301 offer = new RemoveInvalidParentheses_301();
        List<String> res = offer.removeInvalidParentheses("()");
        System.out.println(res);
    }

}
