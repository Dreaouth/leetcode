package leetcode_topInterview;

import java.util.Stack;

public class BasicCalculatorII_227 {

    // cy：当遍历到一个新的运算符时，计算上一个运算符的结果，初始时为一个“+”号，当遍历到字符串最后一位时，还要把上一个运算符拿出来计算结果
    public int calculate(String s) {
        s = s.trim();
        char preSign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int multi = stack.pop();
                        stack.push(multi * num);
                        break;
                    case '/':
                        int divide = stack.pop();
                        stack.push(divide / num);
                        break;
                }
                preSign = c;
                num = 0;
            }

        }
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        return num;
    }

    public static void main(String[] args) {
        BasicCalculatorII_227 offer = new BasicCalculatorII_227();
        int res = offer.calculate(" 3+5 / 2 ");
        System.out.println(res);
    }

}
