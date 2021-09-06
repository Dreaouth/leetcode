package leetcode_top100;

import java.util.Arrays;

public class MaximalRectangle_85 {

    // 方法一：以行为单位遍历，把每次遍历从第一行到现在的高度当作一个柱状图，进行累加。这种方法更好

    // 方法二：类似84题中的动态规划法，面积等于(right-left)*height
    // 给定一行 matrix[i]，我们通过定义三个数组height，left，和 right来记录每个点的h，l，和 r。height[j] 对应matrix[i][j]的高，以此类推
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int max = 0;
        // 以行为单位，边遍历边计算，因为其保存的正好是上一行的结果，省去一维空间复杂度
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            // left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // 计算
            for (int j = 0; j < n; j++) {
                max = Math.max(max, (right[j] - left[j]) * height[j]);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaximalRectangle_85 offer = new MaximalRectangle_85();
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        int res = offer.maximalRectangle(matrix);
        System.out.println(res);
    }
}
