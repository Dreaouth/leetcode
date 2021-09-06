package leetcode_top100;

//25. Reverse Nodes in k-Group(**)
public class ReverseNodesInKGroup_25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 递归法（**）
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count != 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
                count--;
            }
            head = curr;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
