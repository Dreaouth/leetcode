package leetcode_topInterview;

public class SumOfTwoIntegers_371 {

    // 执行加法： x ^ y
    // 执行进位操作 (x & y) << 1
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}
