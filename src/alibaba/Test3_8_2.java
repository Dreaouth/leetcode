package alibaba;

import java.util.Scanner;

/*
小明有一个工厂，工厂有m个任务，然后有n个员工，需要完成p的收益。其中每个任务需要的人数为a[i], 每个任务的收益为b[i]，
要求能达到收益p的完成任务的方式（可以不全部完成任务）
输入：
2
5 2 3
2 2
2 3
8 3 5
3 3 4
2 3 5
输出：
2
4
 */
public class Test3_8_2 {

    public static final int M = 101;

    public static void main(String[] args) {
        int t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            int m, n, p;
            m = scanner.nextInt();
            n = scanner.nextInt();
            p = scanner.nextInt();
            int[] group = new int[m];
            int[] profit = new int[m];
            for (int i = 0; i < m; i++) {
                group[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                profit[i] = scanner.nextInt();
            }
            // dp[i][j]表示利润为i,人数为j的方案数
            int[][] dp = new int[M*M][M];

        }
    }
}
