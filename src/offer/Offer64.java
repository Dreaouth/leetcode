package offer;

import java.util.*;

// 滑动窗口地最大值（**）
public class Offer64 {
    // 单调队列，双端队列
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num.length < size || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        // 首先遍历还没有形成窗口的情况
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && deque.peekLast() < num[i]) {
                deque.removeLast();
            }
            deque.addLast(num[i]);
        }
        res.add(deque.peekFirst());
        // 然后遍历形成窗口的数组
        for (int i = size; i < num.length; i++) {
            // 滑动窗口的low端检测到窗口要移出
            if (deque.peekFirst() == num[i - size]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < num[i]) {
                deque.removeLast();
            }
            deque.addLast(num[i]);
            res.add(deque.peekFirst());
        }
        return res;
    }

    public static void main(String[] args) {
        Offer64 offer64 = new Offer64();
        int[] num = {9,10,9,-7,-4,-8,2,-6};
        ArrayList<Integer> res = offer64.maxInWindows(num, 5);
        for (int n : res) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
