package leetcode_top100;

public class RemoveNthNodeFromEndOfList_19 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        ListNode node = head;
        pre.next = head;
        while (node != null) {
            System.out.println(n);
            if (n > 0) {
                node = node.next;
                n--;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        if (pre.val == -1) {
            return pre.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
