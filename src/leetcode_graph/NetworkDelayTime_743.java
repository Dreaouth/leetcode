package leetcode_graph;

import java.util.*;

public class NetworkDelayTime_743 {

    public int networkDelayTime(int[][] times, int n, int s) {
        int [][]edge = new int[n][n];
        for (int i = 0; i < edge.length; i++) {
            for (int j = 0; j < edge[i].length; j++){
                if (i == j) continue;
                edge[i][j] = 10000;
            }
        }
        for (int i = 0; i < times.length; i++) {
            edge[times[i][0] - 1][times[i][1] - 1] = times[i][2];
        }
        s -= 1;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (edge[i][j] > edge[i][k] + edge[k][j]) {
                        edge[i][j] = edge[i][k] + edge[k][j];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < edge[s].length; i++) {
            if (i == s) continue;
            if (edge[s][i] == 10000) return -1;
            max = Math.max(max, edge[s][i]);
        }
        return max;
    }



    public static void main(String[] args) {
        NetworkDelayTime_743 offer = new NetworkDelayTime_743();
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int res = offer.networkDelayTime(times, 4, 2);
        System.out.println(res);
    }
}
