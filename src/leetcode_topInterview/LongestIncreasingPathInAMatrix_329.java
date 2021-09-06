package leetcode_topInterview;

public class LongestIncreasingPathInAMatrix_329 {

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] memory = new int[rows][columns];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                res = Math.max(res, dfs(matrix, i, j, memory));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memory) {
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        ++memory[i][j];
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newColumn = j + dir[1];
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                memory[i][j] = Math.max(memory[i][j], dfs(matrix, newRow, newColumn, memory) + 1);
            }
        }
        return memory[i][j];
    }
}
