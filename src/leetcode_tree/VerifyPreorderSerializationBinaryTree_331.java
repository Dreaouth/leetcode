package leetcode_tree;

import java.util.Stack;

public class VerifyPreorderSerializationBinaryTree_331 {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        String []strs = preorder.split(",");
        if (strs.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int index = 0;
        while (!stack.isEmpty()) {
            if (index == strs.length) {
                break;
            }
            if (strs[index].equals("#")) {
                stack.pop();
            } else {
                int num = Integer.parseInt(strs[index]);
                stack.push(num);
            }
            index++;
        }
        //System.out.println(index + " " + strs[index]);
        if (index == strs.length && stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationBinaryTree_331 offer = new VerifyPreorderSerializationBinaryTree_331();
        boolean res = offer.isValidSerialization("91,13,14,#,#,10");
        System.out.println(res);
    }

}
