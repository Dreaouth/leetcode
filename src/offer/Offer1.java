package offer;
// 二维数组的查找
public class Offer1 {
    public static boolean Find(int target, int [][] array) {
        int length = array.length;
        if (length == 0) {
            return false;
        }
        int high = array[0].length;
        int i = length - 1;
        int j = 0;
        while (i >= 0 && j < high) {
            if (array[i][j] == target) {
                return true;
            }
            if (target > array[i][j]) {
                j += 1;
            }
            else if (target < array[i][j]) {
                i -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = { {1, 3, 4, 7}, {2, 4, 6, 8}, {10, 12, 14, 16}, {100, 200, 300, 400} };
        int target = 401;
        boolean res = Find(target, arr);
        System.out.println(res);
    }
}
