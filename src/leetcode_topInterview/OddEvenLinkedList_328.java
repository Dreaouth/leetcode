package leetcode_topInterview;

public class OddEvenLinkedList_328 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode next = head.next.next;
        while (next != null) {
            odd.next = next;
            even.next = next.next;
            odd = odd.next;
            even = even.next;
            if (even == null) {
                break;
            }
            next = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
