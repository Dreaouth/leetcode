package leetcode_topInterview;

public class KthSmallestElementInASortedMatrix_378 {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0], right = matrix[m - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(matrix, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k) {
        int i = matrix.length - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= mid) {
                j++;
                num += i + 1;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        KthSmallestElementInASortedMatrix_378 offer = new KthSmallestElementInASortedMatrix_378();
        int res = offer.kthSmallest(matrix, 8);
        System.out.println(res);
    }
}
