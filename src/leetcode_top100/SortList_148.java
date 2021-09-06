package leetcode_top100;

//148. Sort List(**)
public class SortList_148 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 由于不能开辟额外空间，而归并排序的原理是通过递归先排序最少的元素，然后分别合并各个有序数组，所以本问题天生适合归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        temp.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    // 相当于合并两个有序数组
    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if (p1 != null) {
            temp.next = p1;
        }
        if (p2 != null) {
            temp.next = p2;
        }
        return res.next;
    }

    public static void main(String[] args) {

    }
}
