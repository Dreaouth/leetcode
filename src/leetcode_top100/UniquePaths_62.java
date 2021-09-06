package leetcode_top100;

//62. Unique Paths(**)
public class UniquePaths_62 {

    // 动态规划：地图上每一个格子代表走到这里的方法有几种，等于其上面一格和右面一格的方法之和，所以dp[i][j] = dp[i-1][j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths_62 offer = new UniquePaths_62();
        int res = offer.uniquePaths(3, 2);
        System.out.println(res);
    }
}
