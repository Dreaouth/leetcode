package leetcode_top100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KthSmallestElementInABST_230 {

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

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if (k == 0) {
                return temp.val;
            }
            root = temp.right;
        }
        return 0;
    }

}
