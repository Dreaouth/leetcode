package offer;

import java.util.ArrayList;

//顺时针打印矩阵
public class Offer19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int count = 0;
        int sum = (down + 1) * (right + 1);
        while (up <= down && left <= right && count <= sum) {
            for (int i=left; i <= right; i++) {
                res.add(matrix[up][i]);
                count += 1;
            }
            for (int i=up+1; i <= down; i++) {
                res.add(matrix[i][right]);
                count += 1;
            }
            if (count == sum) {
                break;
            }
            for (int i=right-1; i >= left; i--) {
                res.add(matrix[down][i]);
                count += 1;
            }
            if (count == sum) {
                break;
            }
            for (int i=down-1; i >= up+1 ;i--) {
                res.add(matrix[i][left]);
                count += 1;
            }
            up += 1;
            down -= 1;
            left += 1;
            right -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer19 offer19 = new Offer19();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        int[][] matrix2 = {{0}};
        ArrayList<Integer> res = offer19.printMatrix(matrix);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
