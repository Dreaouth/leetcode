package leetcode_top100;

public class UniquePathsII_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i-1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII_63 offer = new UniquePathsII_63();
        int[][] nums = {{0,0},{1,1},{0,0}};
        int res = offer.uniquePathsWithObstacles(nums);
        System.out.println(res);
    }
}
