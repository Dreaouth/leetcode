package offer;

import java.util.ArrayList;

// 二叉树中和为某一值的路径
public class Offer24 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    // 先序遍历+路径记录
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        getPath(root, target);
        return pathList;
    }

    public void getPath(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            pathList.add(new ArrayList<>(path));
        }
        getPath(root.left, target);
        getPath(root.right, target);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {

    }
}
