package offer;

// 反转链表
public class Offer15 {

    static class ListNode {
        public int val; //用于保存数据
        public ListNode next;   //用于保存下一个节点

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        else if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode next = head.next;
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
