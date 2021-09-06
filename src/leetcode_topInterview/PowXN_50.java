package leetcode_topInterview;

public class PowXN_50 {

    public double myPow(double x, int n) {
        int mod;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = n + 2;
            }
            n = -n;
            x = 1 / x;
        }

        double fang = x;
        double res = 1;
        while (n > 0) {
            mod = n % 2;
            n /= 2;
            if (mod == 1) {
                res *= fang;
            }
            fang = fang * fang;
        }
        return res;
    }

    public static void main(String[] args) {
        PowXN_50 offer = new PowXN_50();
        double res = offer.myPow(2.0000, -2147483648);
        System.out.println(res);
    }
}
