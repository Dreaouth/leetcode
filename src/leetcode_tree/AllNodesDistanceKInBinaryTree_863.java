package leetcode_tree;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    List<Integer> res;

    public static class NodeWithK {
        TreeNode node;
        int distance;
        NodeWithK(TreeNode node, int distance) {
            this.distance = distance;
            this.node = node;
        }
    }

    // 先通过dfs找到target，然后根据该target向下寻找，并在上层返回时也更改k进行查找
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new ArrayList<>();
        dfs(root, target, K);
        return res;
    }

    public NodeWithK dfs(TreeNode node, TreeNode target, int k) {
        if (node == target) {
            getDistanceK(node, k);
            return new NodeWithK(target, 1);
        } else if (node == null) {
            return new NodeWithK(null, k);
        }
        NodeWithK left = dfs(node.left, target, k);
        NodeWithK right = dfs(node.right, target, k);
        if (left.node == null && right.node == null) {
            return new NodeWithK(null, k);
        } else if (left.node != null) {
            if (k - left.distance == 0) {
                res.add(node.val);
                return new NodeWithK(null, k);
            } else {
                getDistanceK(node.right, k - left.distance - 1);
                return new NodeWithK(target, left.distance + 1);
            }
        } else {
            if (k - right.distance == 0) {
                res.add(node.val);
                return new NodeWithK(null, k);
            } else {
                getDistanceK(node.left, k - right.distance - 1);
                return new NodeWithK(target, right.distance + 1);
            }
        }
    }

    public void getDistanceK(TreeNode node, int k) {
        if (node == null) {
            return;
        } else if (k == 0) {
            res.add(node.val);
            return;
        }
        getDistanceK(node.left, k - 1);
        getDistanceK(node.right, k - 1);
    }

}
