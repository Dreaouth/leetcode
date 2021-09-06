package leetcode_top100;

// 543. Diameter of Binary Tree(**)
public class DiameterOfBinaryTree_543 {

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

    public int max = 0;

    // 在计算二叉树高的递归过程中，每次都是比较左右子树的高度，然后取最高，这里改为比较左右子树高度的和，然后取最大值即二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        max = Math.max(max, right + left);
        return 1 + Math.max(left, right);
    }


}
