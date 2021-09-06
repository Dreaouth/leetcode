package offer;

// 复杂链表的复制
public class Offer25 {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    // 插裆法
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode temp = pHead;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }
        RandomListNode currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        RandomListNode oldList = pHead;
        RandomListNode newList = pHead.next;
        temp = pHead.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            if (newList.next == null) {
                break;
            }
            newList.next = newList.next.next;
            oldList = oldList.next;
            newList = newList.next;
        }
        return temp;
    }
}
