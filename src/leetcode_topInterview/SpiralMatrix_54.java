package leetcode_topInterview;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int num = 0;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (left <= right && up <= down && num < m * n) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
                num++;
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
                num++;
            }
            if (num == m * n) {
                break;
            }
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[down][i]);
                num++;
            }
            for (int i = down - 1; i > up; i--) {
                res.add(matrix[i][left]);
                num++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix_54 offer = new SpiralMatrix_54();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = offer.spiralOrder(matrix);
        System.out.println(res);
    }

}
