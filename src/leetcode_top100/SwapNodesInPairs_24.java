package leetcode_top100;

public class SwapNodesInPairs_24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        head = pre;
        ListNode node = pre.next;
        while (node != null && node.next != null) {
            ListNode tmp = node.next;
            pre.next = tmp;
            node.next = tmp.next;
            tmp.next = node;
            pre = node;
            node = node.next;
        }
        return head.next;
    }

}
