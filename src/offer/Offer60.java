package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 把二叉树打印成多行
public class Offer60 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            // 这里要用--，因为内部循环中queue进行了递增，如果不用--会一直递增
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) { queue.add(node.left);}
                if (node.right != null) { queue.add(node.right);}
                tmp.add(node.val);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
