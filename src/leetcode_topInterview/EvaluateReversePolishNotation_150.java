package leetcode_topInterview;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                }
                case "*": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 * num1);
                    break;
                }
                case "/": {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                }
                default:
                    int num = Integer.parseInt(token);
                    stack.push(num);
                    break;
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation_150 offer = new EvaluateReversePolishNotation_150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int res = offer.evalRPN(tokens);
        System.out.println(res);
    }
}
