package leetcode_top100;

//29. Divide Two Integers(**)
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        int sign = (dividend < 0)^(divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        while (dvs <= dvd) {
            long temp = dvs;
            long mul = 1;
            // 除数不断翻倍
            while (dvd >= temp << 2) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            res += mul;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers offer = new DivideTwoIntegers();
        int res = offer.divide(7, -3);
        System.out.println(res);
    }
}
