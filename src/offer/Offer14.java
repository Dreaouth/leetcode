package offer;

//链表中倒数第k个结点
public class Offer14 {

    static class ListNode {
        public int val; //用于保存数据
        public ListNode next;   //用于保存下一个节点

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (k > 0) {
            // 修复bug
            if (node == null) {
                return null;
            }
            node = node.next;
            k -= 1;
        }
        while (node != null) {
            node = node.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
