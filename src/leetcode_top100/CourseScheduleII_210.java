package leetcode_top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }
        int visited = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int index = queue.poll();
            res[visited] = index;
            visited++;
            for (int v : edges.get(index)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (visited == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }

}
