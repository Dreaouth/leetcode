package offer;

import java.util.Stack;

//包含min函数的栈（*）
public class Offer20 {

    // 空间换时间->辅助栈
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minS = new Stack<>();

    public void push(int node) {
        if (stack.empty()) {
            stack.push(node);
            minS.push(node);
        }
        else {
            int temp = minS.peek();
            minS.push(Math.min(node, temp));
            stack.push(node);
        }
    }

    public void pop() {
        stack.pop();
        minS.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minS.peek();
    }

    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
        offer20.push(3);
        System.out.println(offer20.min());
        offer20.push(4);
        System.out.println(offer20.min());
        offer20.push(2);
        System.out.println(offer20.min());
        offer20.push(3);
        System.out.println(offer20.min());
        offer20.pop();
        System.out.println(offer20.min());
        offer20.pop();
        System.out.println(offer20.min());
    }
}
