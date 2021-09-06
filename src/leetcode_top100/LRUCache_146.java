package leetcode_top100;

import java.util.HashMap;

// 146.LRU Cache （ HashMap<Integer, DLinkedList> 哈希表+双向链表，哈希表用于随机访问，链表用于插入删除）
public class LRUCache_146 {

    class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList next;
        public DLinkedList() {}
        public DLinkedList(int _key, int _value) {key = _key; value = _value;}
    }

    HashMap<Integer, DLinkedList> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedList head, tail;


    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.next = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkedList node = cache.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            DLinkedList node = cache.get(key);
            node.value = value;
            moveToHead(node);
            cache.put(key, node);
        } else {
            DLinkedList node = new DLinkedList(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                DLinkedList tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private void addToHead(DLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedList removeTail() {
        DLinkedList res = tail.pre;
        removeNode(res);
        return res;
    }
}
