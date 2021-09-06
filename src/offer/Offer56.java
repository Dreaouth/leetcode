package offer;

// 删除链表中重复的结点
public class Offer56 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 排序链表：1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode pre = new ListNode(-1);
        pre.next = pHead;
        ListNode p = pHead;
        ListNode res = pre;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                pre.next = p.next;
                p = p.next;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {

    }
}
