package leetcode_top100;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII_95 {

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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res = getAns(1, n);
        return res;
    }

    public List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        // 即左子树为空的情况
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            TreeNode tmp = new TreeNode(start);
            ans.add(tmp);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            // 返回以i为根节点的左子树list，第一次遍历时，start > end，即返回左子树为空，很巧妙
            List<TreeNode> leftList = getAns(start, i - 1);
            // 返回以i为根节点的右子树list
            List<TreeNode> rightList = getAns(i + 1, end);
            // 将根节点和左右子树进行自由组合
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

}
