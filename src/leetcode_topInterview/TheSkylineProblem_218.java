package leetcode_topInterview;

import java.util.*;

public class TheSkylineProblem_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            queue.add(new int[]{building[0], -building[2]});
            queue.add(new int[]{building[1], building[2]});
        }
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (tmp[1] < 0) {
                heights.put(-tmp[1], heights.getOrDefault(-tmp[1], 0) + 1);
            } else {
                heights.put(tmp[1], heights.get(tmp[1]) - 1);
                if (heights.get(tmp[1]) == 0) heights.remove(tmp[1]);
            }
            int maxHeight = heights.firstKey();
            if (maxHeight != height) {
                left = tmp[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
