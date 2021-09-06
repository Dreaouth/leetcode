package leetcode_top100;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k && nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            } else if (queue.size() < k){
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 offer = new KthLargestElementInAnArray_215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int res = offer.findKthLargest(nums, 4);
        System.out.println(res);
    }

}
