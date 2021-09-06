package leetcode_top100;

// 124. Binary Tree Maximum Path Sum(***)
public class BinaryTreeMaximumPathSum_124 {

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

    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        // 这里的path代表此处已经停止了（不进行向上递归），所以要将左和右进行相加，然后计算以此节点为拐点的最大路径和
        int path = root.val + leftMax + rightMax;
        maxPath = Math.max(maxPath, path);
        // 返回的代表继续向上递归，所以要返回左右子树中路径最大的那个
        return root.val + Math.max(leftMax, rightMax);
    }

}
