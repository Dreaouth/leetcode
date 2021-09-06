package leetcode_top100;

// 337. House Robber III(**)
public class HouseRobberIII_337 {

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

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        // res[0]表示左子树和右子树都没有使用
        res[0] = left[1] + right[1] + root.val;
        // res[1]表示用到了左子树或右子树(**)
        res[1] = Math.max(left[0],left[1]) + Math.max(right[1], right[0]);
        return res;
    }

    public static void main(String[] args) {

    }
}
