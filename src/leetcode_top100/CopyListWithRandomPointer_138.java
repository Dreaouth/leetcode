package leetcode_top100;

public class CopyListWithRandomPointer_138 {


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node tempNext = node.next;
            Node newNode = new Node(node.val);
            node.next = newNode;
            newNode.next = tempNext;
            node = tempNext;
        }

        Node nn = head;
        while (nn != null) {
            System.out.print(nn + " ");
            nn = nn.next;
        }
        System.out.println();

        node = head;
        Node pre;
        while (node != null) {
            pre = node;
            node = node.next;
            if (pre.random != null) {
                node.random = pre.random.next;
            } else
                node.random = null;
            node = node.next;
        }
        Node oldNode = head;
        Node newNode = head.next;
        node = newNode;
        while (oldNode != null) {
            oldNode.next = oldNode.next.next;
            if (newNode.next == null) {
                break;
            }
            newNode.next = newNode.next.next;
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return node;
    }

    public static void main(String[] args) {

    }
}
