package offer;

// 两个链表的第一个公共结点
public class Offer36 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0, length2 = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null) {
            p1 = p1.next;
            length1 += 1;
        }
        while (p2 != null) {
            p2 = p2.next;
            length2 += 1;
        }
        if (length2 > length1) {
            while (length2 > length1 && pHead2 != null) {
                pHead2 = pHead2.next;
                length2--;
            }
        } else {
            while (length1 > length2 && pHead1 != null) {
                pHead1 = pHead1.next;
                length1--;
            }
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public static void main(String[] args) {

    }
}
