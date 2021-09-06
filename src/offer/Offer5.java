package offer;

import java.util.Stack;
// 用两个栈实现队列
public class Offer5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                return -1;
            }
            else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
        else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Offer5 offer5 = new Offer5();
        offer5.push(4);
        offer5.push(3);
        offer5.push(10);
        int a = offer5.pop();
        int b = offer5.pop();
        int c = offer5.pop();
        int d = offer5.pop();
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}
