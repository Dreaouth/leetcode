package leetcode_top100;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        //dfs(res, root);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }

    public void dfs(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(res, node.left);
        res.add(node.val);
        dfs(res, node.right);
    }
}
