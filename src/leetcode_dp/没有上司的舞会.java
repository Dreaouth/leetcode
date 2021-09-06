package leetcode_dp;

import java.util.Scanner;

public class 没有上司的舞会 {

    public static void dfs(int x, int [][]edge,int [][]dp, int []happy) {
        for (int i = 1; i < edge.length; i++) {
//            System.out.println(i);
            if (edge[x][i] == 1) {
                dfs(i, edge, dp, happy);
                dp[x][0] += Math.max(dp[i][1], dp[i][0]);
                dp[x][1] += dp[i][0];
            }
        }
        dp[x][1] += happy[x];
    }

    // 树形dp，dp[i][1]表示选择这个点时的最大值，dp[i][0]表示不选择这个点取的最大值
    // 方程为 dp[x][0] += max(dp[i][1], dp[i][0]);  dp[x][1] += dp[i][0]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int []happy = new int[n + 1];
        int [][]edge = new int[n + 1][n + 1];
        int [][]dp = new int[n + 1][2];
        int []boss = new int[n + 1];

        for (int i = 0; i < n; i++) {
            happy[i + 1] = scanner.nextInt();
        }
        while (scanner.hasNext()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edge[to][from] = 1;
            boss[from] = to;
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(edge[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int i = 1; i<= n; i++) {
            if (boss[i] == 0) {
                dfs(i, edge, dp, happy);
                System.out.println(Math.max(dp[i][1], dp[i][0]));
                break;
            }
        }
    }
}
