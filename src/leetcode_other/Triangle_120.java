package leetcode_other;

import java.util.List;

public class Triangle_120 {

    int min = Integer.MAX_VALUE;

    // 自底向上的动态规划
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size() + 1];
        // 从最后一行开始往前递推
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    // dfs方法：TLE
    public void dfs(List<List<Integer>> triangle, int row, int column, int sum) {
        if (row == triangle.size()) {
            return;
        }
        sum += triangle.get(row).get(column);
        if (row == triangle.size() - 1) {
            System.out.println(sum);
            min = Math.min(min, sum);
        }
        dfs(triangle, row + 1, column, sum);
        if (column == triangle.get(row).size() - 1)  {
            System.out.println("row " + row);
            dfs(triangle, row + 1, column + 1, sum);
            System.out.println("col " + column);
        }
    }

}

