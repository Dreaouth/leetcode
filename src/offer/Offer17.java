package offer;

// 树的子结构（*）
public class Offer17 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 从每一个节点开始递归判断
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null) {
            return false;
        }
        boolean res = false;
        if(root1.val == root2.val) {
            res = judgeSubtree(root1, root2);
        }
        if(!res) {
            res = HasSubtree(root1.left, root2);
        }
        if (!res) {
            res = HasSubtree(root1.right, root2);
        }
        return res;
    }

    public boolean judgeSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        else if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        else
            return judgeSubtree(root1.left, root2.left) && judgeSubtree(root1.right, root2.right);
    }

    public static void main(String[] args) {

    }
}
