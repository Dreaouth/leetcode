package leetcode_top100;

import java.util.Arrays;
import java.util.LinkedList;

// 56. Merge Intervals(*)
public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] interval : intervals) {
            if (res.isEmpty() || res.getLast()[1] < interval[0]) {
                res.add(interval);
            } else {
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals_56 offer = new MergeIntervals_56();
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = offer.merge(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + '.');
            }
            System.out.println();
        }
    }
}
