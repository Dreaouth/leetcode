package leetcode_topInterview;

public class FactorialTrailingZeroes_172 {

    //cy：只有 2*5=10
    public int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes_172 offer = new FactorialTrailingZeroes_172();
        int res = offer.trailingZeroes(16);
        System.out.println(res);
    }

}
