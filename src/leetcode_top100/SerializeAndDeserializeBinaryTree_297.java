package leetcode_top100;

public class SerializeAndDeserializeBinaryTree_297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.

    StringBuilder serial = new StringBuilder();
    private int num = 0;

    public String serialize(TreeNode root) {
        if (root == null) {
            serial.append("#,");
            return serial.toString();
        }
        serial.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
        System.out.println(serial.toString());
        return serial.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        if (ss.length == 0) {
            return null;
        }
        TreeNode root = dfs(ss);
        return root;
    }

    public TreeNode dfs(String[] ss) {
        if (ss[num].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(ss[num]));
        num++;
        node.left = dfs(ss);
        num++;
        node.right = dfs(ss);
        return node;
    }

}
