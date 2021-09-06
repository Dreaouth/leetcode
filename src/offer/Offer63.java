package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// 数据流中的中位数（**）
public class Offer63 {

    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    // 用一个大根堆和一个小跟堆
    public void Insert(Integer num) {
        // 当两个队列大小相同地情况下，插入到大顶堆
        if (maxQueue.size() == minQueue.size()) {
            if (!minQueue.isEmpty() && num > minQueue.peek()) {
                minQueue.add(num);
                num = minQueue.poll();
            }
            maxQueue.add(num);
        } else if (maxQueue.size() == minQueue.size() + 1) {
            if (num < maxQueue.peek()) {
                maxQueue.add(num);
                num = maxQueue.poll();
            }
            minQueue.add(num);
        }
    }

    public Double GetMedian() {
        if (maxQueue.isEmpty() && minQueue.isEmpty()) {
            return null;
        } else if (maxQueue.size() == minQueue.size()) {
            return (double) (minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            return (double) maxQueue.peek();
        }
    }

    public static void main(String[] args) {
        Offer63 offer63 = new Offer63();
        System.out.println(offer63.GetMedian());
        offer63.Insert(1);
        System.out.println(offer63.GetMedian());
        offer63.Insert(3);
        System.out.println(offer63.GetMedian());
        offer63.Insert(4);
        System.out.println(offer63.GetMedian());

    }
}
