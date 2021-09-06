package alibaba;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Test3_12_1 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return false;
        }
        for (int i = 0 ; i < s2.length(); i++) {
            char from = s2.charAt(i);
            for (int j = i + 1; j <s2.length(); j++) {
                char to = s2.charAt(j);
                StringBuilder builder = new StringBuilder(s2);
                builder.replace(i, i+1, String.valueOf(to));
                builder.replace(j, j+1, String.valueOf(from));
                if (s1.equals(builder.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
            System.out.println(map.get(edges[i][0]) + " " + map.get(edges[i][1]));
            if (map.get(edges[i][0]) > 1) {
                return edges[i][0];
            }
            if (map.get(edges[i][1]) > 1) {
                return edges[i][1];
            }
        }
        return -1;
    }

    public class Students {
        public int pass;
        public int total;
        public Students(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Students> queue = new PriorityQueue<>(new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                double pre1 = (double) (o1.pass + 1) / (o1.total + 1) - (double) o1.pass / o1.total;
                double pre2 = (double) (o2.pass + 1) / (o2.total + 1) - (double) o2.pass / o2.total;
                return Double.compare(pre2, pre1);
            }
        });
        for (int i = 0; i < classes.length; i++) {
            Students students = new Students(classes[i][0], classes[i][1]);
            queue.add(students);
        }
        while (extraStudents > 0) {
            Students students = queue.poll();
            students.pass += 1;
            students.total += 1;
            queue.add(students);
            extraStudents--;
        }
        double precent = 0.0;
        while (!queue.isEmpty()) {
            Students students = queue.poll();
            precent += (double) students.pass / students.total;
        }
        return precent / classes.length;
    }

    // 双指针法
    public int maximumScore(int[] nums, int k) {
        int left = k - 1, right = k + 1;
        int res = nums[k];
        int min = nums[k];
        while (left >= -1 && right <= nums.length) {
            if (left == -1) {
                if (right == nums.length) {
                    break;
                }
                min = Math.min(nums[right], min);
                right++;
            } else {
                if (right == nums.length || nums[left] > nums[right]) {
                    min = Math.min(nums[left], min);
                    left--;
                } else {
                    min = Math.min(nums[right], min);
                    right++;
                }
            }
            res = Math.max(res, (right - left - 1) * min);
        }
        return res;
    }

    public static void main(String[] args) {
        Test3_12_1 offer = new Test3_12_1();
        int []edges = {5,5,4,5,4,1,1,1};
        int res = offer.maximumScore(edges, 0);
        System.out.println(res);
    }
}
