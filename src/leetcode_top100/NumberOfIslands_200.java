package leetcode_top100;

public class NumberOfIslands_200 {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !flag[i][j]){
                    sum++;
                    dfs(grid, i, j, flag);
                }
            }
        }
        return sum;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] flag) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, flag);
        dfs(grid, i + 1, j, flag);
        dfs(grid, i, j - 1, flag);
        dfs(grid, i, j + 1, flag);
    }

    public static void main(String[] args) {

    }
}
