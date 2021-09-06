package leetcode_top100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream_295 {

    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;

    public FindMedianFromDataStream_295() {
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxQueue.size() == minQueue.size()) {
            if (!minQueue.isEmpty() && minQueue.peek() < num) {
                int temp = minQueue.poll();
                minQueue.add(num);
                maxQueue.add(temp);
            } else {
                maxQueue.add(num);
            }
        } else {
            if (!maxQueue.isEmpty() && maxQueue.peek() > num) {
                int temp = maxQueue.poll();
                minQueue.add(temp);
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
        }
    }

    public double findMedian() {
        System.out.println(maxQueue.size() + " " + minQueue.size());
        System.out.println(maxQueue.peek() + " " + minQueue.peek());
        if (maxQueue.size() == minQueue.size()) {
            return ((double)maxQueue.peek() + (double)minQueue.peek()) / 2;
        } else {
            return maxQueue.peek();
        }
    }

}
