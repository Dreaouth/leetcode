package leetcode_tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree_958 {


    public static class TreeNode {
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


    // 第一个想法是用数组保存，然后看除最后一个节点外是否满足 i*2和i*2+1是否有节点，但该方法的复杂度较高，需要另外开辟数组
    // 后面想到从右往左遍历，使用层序遍历，每层遍历到的节点，其左边必须有节点
    public boolean isCompleteTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 1;
        boolean last = false;
        int max_height = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            if (height > max_height && flag) {
                return false;
            }
            height++;
            last = false;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (last && node.right == null) {
                    return false;
                }
                if (node.right != null) {
                    last = true;
                    queue.add(node.right);
                }
                if (last && node.left == null) {
                    return false;
                }
                if (node.left != null) {
                    last = true;
                    queue.add(node.left);
                }
                if ((node.left == null || node.right == null) && !flag) {
                    max_height = height;
                    flag = true;
                }
            }
        }
        return true;
    }


}
