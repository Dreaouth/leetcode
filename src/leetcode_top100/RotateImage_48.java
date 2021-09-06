package leetcode_top100;

public class RotateImage_48 {

    // 这个是自己想出来的做法；通用的做法是先上下反转，然后进行中心对称（转置）
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < (matrix.length - i - 1); j++) {
                int right_y = matrix.length - i - 1;
                int low_x = matrix.length - i - 1, low_y = matrix.length - j - 1;
                int left_x = matrix.length - j - 1;
                swap(matrix, i, j, low_x, low_y);
                swap(matrix, i, j, left_x, i);
                swap(matrix, low_x, low_y, j, right_y);
            }
        }

    }

    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        RotateImage_48 offer = new RotateImage_48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2 = {{5,1,9,11,15},{2,4,8,10,16},{13,3,6,7,17},{15,14,12,16,18},{19,20,21,22,23}};
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        offer.rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
