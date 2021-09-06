package leetcode_top100;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            if (pre != null && pre.val >= tmp.val) {
                return false;
            }
            pre = tmp;
            root = tmp.right;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
