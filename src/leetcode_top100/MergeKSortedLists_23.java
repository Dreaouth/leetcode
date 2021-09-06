package leetcode_top100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 优先队列法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 将所有不为空的list的头节点插入到优先队列中
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode pre = new ListNode(-1);
        ListNode node = pre;
        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            node.next = temp;
            if (temp.next != null) {
                queue.add(temp.next);
            }
            node = node.next;
        }
        return pre.next;
    }

    // 递归、归并排序的原理：先拆分，每次只合并2个list，然后4个.....
    public ListNode mergeKLists_2(ListNode[] lists) {
        return mL(lists, 0, lists.length - 1);
    }

    private ListNode mL(ListNode[] lists, int l, int r) {
        if (r < l) return null;
        if (r == l) return lists[r];

        int mid = (l + r) / 2;
        ListNode a = mL(lists, l, mid), b = mL(lists, mid + 1, r);
        ListNode dmHead = new ListNode(0), cur = dmHead;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = (a != null) ? a : b;

        return dmHead.next;
    }

    public static void main(String[] args) {

    }
}
