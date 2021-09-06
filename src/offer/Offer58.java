package offer;

// 对称的二叉树（**）
public class Offer58 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return reCur(pRoot.left, pRoot.right);
    }

    // 递归 reCur(l.left, r.right) && reCur(l.right, r.left)
    boolean reCur(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null || l.val != r.val) {
            return false;
        }
        return reCur(l.left, r.right) && reCur(l.right, r.left);
    }

    public static void main(String[] args) {

    }
}
