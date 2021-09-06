package offer;

// 二叉树的下一个结点
public class Offer57 {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    // 分为三种情况：1.有右孩子 2.没右孩子但其是父节点的左子树 3.没右孩子但其是父节点的右子树
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (pNode.next != null) {
            TreeLinkNode node = pNode.next;
            if (node.left == pNode) {
                return node;
            } else {
                while (node.next != null && node.next.right == node) {
                    node = node.next;
                }
                return node.next;
            }
        } else {
            return null;
        }
    }
}
