package offer;


import java.util.ArrayList;

//从尾到头打印链表
public class Offer3 {

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode node) {
        ArrayList<Integer> reversedList = new ArrayList<>();
        if (node.next == null) {
            reversedList.add(node.val);
            return reversedList;
        }
        while (node != null) {
            reversedList.add(0, node.val);
            node = node.next;
        }
        return reversedList;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(15);
        ListNode n3 = new ListNode(25);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ArrayList<Integer> reversedList = printListFromTailToHead(n1);
        for (int i = 0; i < reversedList.size(); i++) {
            System.out.println(reversedList.get(i));
        }
    }
}

