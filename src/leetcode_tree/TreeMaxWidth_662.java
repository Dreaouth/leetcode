package leetcode_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeMaxWidth_662 {


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

    // 重点是：二叉树的某一层的最大宽度等于其满二叉树序号的差
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        int res = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                int pos = linkedList.removeFirst();
                if (node.left != null) {
                    queue.add(node.left);
                    linkedList.add(pos * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    linkedList.add(pos * 2 + 1);
                }
            }
            if (linkedList.size() > 2) {
                res = Math.max(res, linkedList.getLast() -  linkedList.getFirst() + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
