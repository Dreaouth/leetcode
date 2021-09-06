package offer;

// 二叉搜索树的第k个结点
public class Offer62 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    int num;
    TreeNode node;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        num = k;
        dfs(pRoot);
        return node;
    }

    void dfs(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        dfs(pRoot.left);
        num--;
        if (num == 0) {
            node = pRoot;
            return;
        }
        dfs(pRoot.right);
    }
}
