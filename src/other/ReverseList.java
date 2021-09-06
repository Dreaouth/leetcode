package other;


class Node {
    public int val; //用于保存数据
    public Node next;   //用于保存下一个节点

    public Node(int val) {
        this.val = val;
    }
}


public class ReverseList {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(15);
        Node n3 = new Node(25);
        Node n4 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node node = reverseList(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static Node reverseList(Node node) {
        if (node == null) {
            return null;
        }
        else if (node.next == null) {
            return node;
        }
        Node pre = null;
        Node p = node;
        Node next = node.next;
        while (p != null) {
            p.next = pre;
            pre = p;
            p = next;
            if (next != null) {
                next = next.next;
            }
            else {
                next = null;
            }
        }
        return pre;
    }


}
