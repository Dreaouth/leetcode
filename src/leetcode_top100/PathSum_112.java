package leetcode_top100;

public class PathSum_112 {

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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return true;
        }
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int sumPath, int target) {
        sumPath += root.val;
        if (root.left == null && root.right == null) {
            if (target == sumPath) {
                return true;
            }
        }
        boolean left = false;
        if (root.left != null) {
            left = dfs(root.left, sumPath, target);
        }
        boolean right = false;
        if (root.right != null) {
            right = dfs(root.right, sumPath, target);
        }
        return left || right;
    }

}
