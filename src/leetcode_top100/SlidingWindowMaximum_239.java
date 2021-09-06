package leetcode_top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < nums[i]) {
                deque.pollFirst();
            }
            deque.addFirst(nums[i]);
        }
        List<Integer> res = new LinkedList<>();
        res.add(deque.peekLast());
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == deque.peekLast()) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekFirst() < nums[i]) {
                deque.pollFirst();
            }
            deque.addFirst(nums[i]);

            res.add(deque.peekLast());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SlidingWindowMaximum_239 offer = new SlidingWindowMaximum_239();
        int[] nums = {1,3,1,2,0,5};
        int[] res = offer.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.stream(res).boxed().collect(Collectors.toList()));
    }
}
