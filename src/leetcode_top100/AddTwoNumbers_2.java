package leetcode_top100;

//2. Add Two Numbers(*)
public class AddTwoNumbers_2 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    // 具体思路就是：不断循环遍历，当
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int in = 0;
        // 通过三个条件判断是否停止
        while (l1 != null || l2 != null || in != 0) {
            ListNode node = new ListNode(0);
            int tmp = 0;
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            tmp += in;
            // 存储进位信息
            in = tmp / 10;
            node.val = tmp % 10;
            prev.next = node;
            prev = node;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
