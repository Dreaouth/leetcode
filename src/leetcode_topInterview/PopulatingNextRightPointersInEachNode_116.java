package leetcode_topInterview;

public class PopulatingNextRightPointersInEachNode_116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // dfs
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        dfs(root.left, root.right);
        return root;
    }

    public void dfs(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        dfs(left.left, left.right);
        dfs(right.left, right.right);
        dfs(left.right, right.left);
    }


    // cy：层序遍历法
    public void connect_BFS(Node root) {
        Node level_start=root;
        while(level_start!=null){
            Node cur=level_start;
            // 根据next进行层序遍历
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;   // niubi，相当于穿了根线
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }

}
