package leetcode_other;


import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {


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


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), root, sum, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> tempPath, TreeNode node, int sum, int pathSum) {
        if (node == null) {
            return;
        }
        pathSum += node.val;
        tempPath.add(node.val);
        if (node.left == null && node.right == null && pathSum == sum) {
            res.add(new ArrayList<>(tempPath));
            tempPath.remove(tempPath.size() - 1);
            return;
        }
        dfs(res, tempPath, node.left, sum, pathSum);
        dfs(res, tempPath, node.right, sum, pathSum);
        tempPath.remove(tempPath.size() - 1);
    }

}
