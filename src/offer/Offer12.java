package offer;

//数值的整数次方（快速幂**）
public class Offer12 {

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 0;
        }
        if (exponent < 0) {
            base = (1 / base);
            exponent = -exponent;
        }
        double extra = base;
        double res = 1.0;
        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                res *= extra;
            }
            extra *= extra;
            exponent >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer12 offer12 = new Offer12();
        double res = offer12.Power(123.435, 19);
        System.out.println(res);
    }
}
