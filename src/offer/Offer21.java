package offer;

import java.util.Stack;

// 栈的压入、弹出序列
public class Offer21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);
        int i = 0, j = 0;
        while (!stack.empty() && j < popA.length) {
            if(i < pushA.length && popA[j] != pushA[i]) {
                stack.push(pushA[i]);
                i++;
            } else if (i < pushA.length && popA[j] == pushA[i]) {
                i++;
                j++;
            } else if (popA[j] == stack.peek()) {
                stack.pop();
                j++;
            } else if (popA[j] != stack.peek() && i == pushA.length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4,3,5,1,2};
        Offer21 offer21 = new Offer21();
        System.out.println(offer21.IsPopOrder(pushA, popA));
    }
}
