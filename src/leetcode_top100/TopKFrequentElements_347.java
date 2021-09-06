package leetcode_top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[k];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        class A {
            int freq;
            int num;
        }
        PriorityQueue<A> queue = new PriorityQueue<>(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.freq - o2.freq;
            }
        });
        for (int num : map.keySet()) {
            A temp = new A();
            temp.freq = map.get(num);
            temp.num = num;
            queue.add(temp);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
