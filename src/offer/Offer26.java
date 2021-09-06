package offer;

import java.util.Stack;

// 二叉搜索树与双向链表
public class Offer26 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = pRootOfTree;
        while (!stack.empty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null) {
                pre.right = cur;
            }
            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
        while (pre.left != null) {
            pre = pre.left;
        }
        return pre;
    }



    public static void main(String[] args) {

    }
}
