package leetcode_math;

public class QuickPow {

    public int quickPow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) > 0) {
                ans *= a;
            }
            a *= a;
            b /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        QuickPow pow = new QuickPow();
        int res = pow.quickPow(2, 13);
        System.out.println(res);
    }
}
