package leetcode_top100;

public class IntersectionOfTwoLinkedLists_160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode A = headA;
        while (A != null) {
            A = A.next;
            l1++;
        }
        ListNode B = headB;
        while (B != null) {
            B = B.next;
            l2++;
        }
        if (l1 < l2) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        for (int i = 0; i < (Math.abs(l1 - l2)); i++) {
            headA = headA.next;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null || headB == null) {
            return null;
        } else {
            return headA;
        }
    }

}
