package offer;

// 平衡二叉树
public class Offer39 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth(root);
        return flag;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }
}
