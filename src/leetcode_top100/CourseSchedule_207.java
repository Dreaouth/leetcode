package leetcode_top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {

    // 注意：题目中[0,1]表示，先1再0，插入edge时不要插反
    public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
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
        while (!queue.isEmpty()) {
            visited++;
            int index = queue.poll();
            for (int v : edges.get(index)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.add(v);
                }
            }
        }
        return visited == numCourses;
    }

    private int[] state;
    private boolean valid = true;

    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }
        state = new int[numCourses];
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                dfs(i, edges);
            }
        }
        return valid;
    }

    public void dfs(int u, List<List<Integer>> edges) {
        state[u] = 1;
        for (int i : edges.get(u)) {
            if (state[i] == 0) {
                dfs(i, edges);
                if (!valid) {
                    return;
                }
            } else if (state[i] == 1) {
                valid = false;
                return;
            }
        }
        state[u] = 2;
    }
}
