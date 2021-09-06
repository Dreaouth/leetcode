package leetcode_array;

public class ReorderList_143 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode half = head;
        ListNode tail = head;
        ListNode set = head;
        while (tail != null && tail.next != null) {
            set = half;
            half = half.next;
            tail = tail.next.next;
        }
        if (tail != null) {
            set = half;
            half = half.next;
        }
        set.next = null;
        half = reverseList(half);
        ListNode pre = head;
        ListNode next = head.next;


        while (half != null) {
            ListNode temp = half.next;
            pre.next = half;
            half.next = next;
            pre = next;
            next = next == null ? next : next.next;
            half = temp;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = head.next;
        while (head != null) {
            head.next = pre;
            pre = head;
            head = next;
            next = next == null ? next : next.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReorderList_143 offer = new ReorderList_143();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        offer.reorderList(l1);
    }
}
