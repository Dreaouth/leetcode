package offer;

import java.util.LinkedList;
import java.util.Queue;

// 序列化二叉树（**）
public class Offer61 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    StringBuilder serial = new StringBuilder();
    int num = -1;

    // 尝试用前序递归法和层序遍历法两种方法
    String Serialize_pre(TreeNode root) {
        if (root == null) {
            serial.append("#,");
            return serial.toString();
        } else {
            serial.append(root.val).append(",");
        }
        Serialize_pre(root.left);
        Serialize_pre(root.right);
        return serial.toString();
    }

    TreeNode Deserialize_pre(String str) {
        String[] ss = str.split(",");
        System.out.println(ss.length);
        if (ss.length == 0) {
            return null;
        }
        TreeNode pre = pre_Cur(ss);
        return pre;
    }

    TreeNode pre_Cur(String[] strs) {
        num += 1;
        if (num >= strs.length) {
            return null;
        }
        TreeNode root;
        if (!strs[num].equals("#")) {
            root = new TreeNode(Integer.parseInt(strs[num]));
            root.left = pre_Cur(strs);
            root.right = pre_Cur(strs);
        } else {
            root = null;
        }
        return root;
    }


    String Serialize_level(TreeNode root) {
        if (root == null) {
            return serial.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 和正常的层序遍历有些不同
            if (node != null) {
                serial.append(node.val).append(',');
                queue.add(node.left);
                queue.add(node.right);
            } else {
                serial.append("#,");
            }
        }
        return serial.toString();
    }

    TreeNode Deserialize_level(String str) {
        String[] ss = str.split(",");
        System.out.println(ss.length + " " + str);
        if (ss.length == 0 ) {
            return null;
        } else if (ss.length == 1 && ss[0].equals("")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!ss[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(ss[i]));
                queue.add(node.left);
            }
            i++;
            if (!ss[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(ss[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Offer61 offer61 = new Offer61();
        TreeNode p1 = new TreeNode(8);
        TreeNode p2 = new TreeNode(6);
        TreeNode p3 = new TreeNode(10);
        TreeNode p4 = new TreeNode(7);
        TreeNode p5 = new TreeNode(9);
        TreeNode p6 = new TreeNode(11);
        p1.left = p2;
        p1.right = p3;
        p2.right = p4;
        p3.left = p5;
        p3.right = p6;
        String res = offer61.Serialize_level(null);
        offer61.Deserialize_level(res);
        System.out.println(res);
    }
}
