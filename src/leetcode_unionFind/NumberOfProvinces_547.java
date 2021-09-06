package leetcode_unionFind;

import java.util.HashMap;

public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {
        boolean []visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int [][]isConnected, boolean []visited, int start) {
        visited[start] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (start == i) continue;
            if (isConnected[start][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public static void main(String[] args) {

    }
}
