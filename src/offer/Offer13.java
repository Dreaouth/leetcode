package offer;

// 调整数组顺序使奇数位于偶数前面（时间法和空间法*）
public class Offer13 {

    // 时间O(n2)
    public void reOrderArray(int [] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if ((array[j] & 1) != 0) {
                int temp = array[j];
                move(array, i, j - 1);
                array[i] = temp;
                i += 1;
            }
        }

        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public void move(int []array, int a, int b) {
        if (b < a) {
            return;
        }
        for (int i = b; i >= a; i--) {
            array[i + 1] = array[i];
        }
    }

    public static void main(String[] args) {
        Offer13 offer13 = new Offer13();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        offer13.reOrderArray(array);
    }
}
